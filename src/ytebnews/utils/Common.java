/**
 * Copyright(C) 2019 Tran Thanh Viet
 * Common.java, Oct 12, 2019 VietTT
 */
package ytebnews.utils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Chứa các hàm common của dự án
 * 
 * @author VietTT
 *
 */
public class Common {
	private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
	private static final int MAX_FILE_SIZE      = 1024 * 1024 * 90; // 90MB
	private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 100; // 100MB
	/**
	 * Mã hóa SHA1
	 * 
	 * @param pass mật khẩu chưa đc mã hóa
	 * @param salt muối thêm vào
	 * @return pass đã đc mã hóa
	 */
	public static String encryptPass(String pass, String salt) throws NoSuchAlgorithmException {
		byte[] saltByte = new byte[16];
		saltByte = salt.getBytes();
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			// update muối
			md.update(saltByte);
			// Kết quả mảng byte
			byte[] result = md.digest(pass.getBytes(StandardCharsets.UTF_8));
			// Chuyển sang string
			for (int i = 0; i < result.length; i++) {
				sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println(Common.class.getName() + "-" + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ e.getMessage());
			throw e;
		}
		return sb.toString();
	}

	/**
	 * Lấy muối bằng thời gian hiện tại
	 * 
	 * @return salt
	 */
	public static String getSalt() {
		// Lấy time hiện tại tinh den milisecon s
		String salt = ZonedDateTime.now().toInstant().toEpochMilli() + "";
		return salt;
	}

	/**
	 * Chuyển đổi các ký tự đặc biệt sql
	 * 
	 * @param value full name
	 * @return value giá trị sau khi chuyển đổi
	 */
	public static String replaceSqlWildcard(String value) {
		if (Common.checkEmpty(value)) {
			value = value.replace("\\", "\\\\");
			value = value.replace("%", "\\%");
			value = value.replace("_", "\\_");
		}
		return value;
	}

	/**
	 * Check nhập
	 * 
	 * @param input dữ liệu nhập vào
	 * @return true có nhập, false k nhập
	 */
	public static boolean checkEmpty(String input) {
		boolean isEmpty = false;
		if (!input.trim().isEmpty()) {
			isEmpty = true;
		}
		return isEmpty;
	}

	/**
	 * Tạo chuỗi paging
	 * 
	 * @param totalNews   tổng sô user
	 * @param limit       số lượng cần hiển thị trên 1 trang
	 * @param currentPage trang hiện tại
	 * @return listPage Danh sách các trang cần hiển thị ở chuỗi paging theo trang
	 *         hiện tại
	 */
	public static List<Integer> getListPaging(int totalNews, int limit, int currentPage) {
		List<Integer> listPage = new ArrayList<Integer>();
		int maxPage = 0;
		int maxTotalPage = getTotalPage(totalNews, limit);
		if (totalNews > Constant.LIMIT) {
			// Giá trị lớn nhất trong listPaging
			maxPage = (int) (Math.ceil((double) currentPage / (double) Constant.PAGING_PAGE)) * Constant.PAGING_PAGE;
			// Lấy các phần tử còn lại add vào list
			for (int i = Constant.PAGING_PAGE - 1; i >= 0; i--) {

				if (maxPage - i > maxTotalPage) {
					break;
				}
				listPage.add(maxPage - i);

			}
		}
		return listPage;
	}

	/**
	 * Lấy số trang lớn nhất
	 * 
	 * @param totalNews tổng sô user
	 * @param limitsố   lượng cần hiển thị trên 1 trang
	 * @return số trang lớp nhất
	 */
	public static int getTotalPage(int totalNews, int limit) {
		int maxTotalPage = (int) Math.ceil((double) totalNews / (double) limit);
		return maxTotalPage;
	}

	/**
	 * Lấy vị trí data cần lấy
	 * 
	 * @param currentPage Trang hiện tại
	 * @param limit       số lượng cần hiển thị trên 1 trang
	 * @return vị trí cần lấy
	 */
	public static int getOffset(int currentPage, int limit) {
		int offSet = (currentPage - 1) * limit;
		return offSet;
	}

	/**
	 * Hàm chuỗi chuỗi String sang số
	 * 
	 * @param input        chuỗi số
	 * @param defaultValue giá trị kết quả nếu không chuyển được
	 * @return result kết quả sau khi chuyển đổi
	 */
	public static int parseInt(String input, int defaultValue) {
		// Khai báo biến kết quả
		int result = 0;
		try {
			// Chuyển chuỗi số sang số
			result = Integer.parseInt(input);

		} catch (NumberFormatException e) {
			// Kết quả chuyển ki bị lỗi
			result = defaultValue;
		}
		return result;
	}

	/**
	 * Upload ảnh lên server
	 * 
	 * @param request
	 * @return tên ảnh lưu vào DB
	 */
	public static void uploadFile(HttpServletRequest request, String nameImage) {
		// xử lý upload file khi người dùng nhấn nút thực hiện
		try {
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setSizeThreshold(MEMORY_THRESHOLD);
			fileItemFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		     // sets maximum size of upload file
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	        // sets maximum size of request (include file + form data)
	        upload.setSizeMax(MAX_REQUEST_SIZE);
			List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					// xử lý file
					if (!"".equals(nameImage)) {
						String dirUrl = request.getServletContext().getRealPath("") + File.separator
								+ Constant.IMAGES_NEWS_FOLDER;
						File dir = new File(dirUrl);
						if (!dir.exists()) {
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameImage;
						File file = new File(fileImg);
						fileItem.write(file);
						System.out.println(fileImg);
					}
				}
			}
		} catch (Exception e) {
			nameImage = null;
			e.printStackTrace();
		}

	}

	/**
	 * Lấy thời gian hiện tại
	 * 
	 * @return timeNow thời gian hiện tại
	 */
	public static String getTimeNow() {
		String timeNow = "";
		Calendar cal = Calendar.getInstance();
		int dayNow = cal.get(Calendar.DATE);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int yearNow = cal.get(Calendar.YEAR);
		timeNow = yearNow + "-" + monthNow + "-" + dayNow;
		return timeNow;
	}
}
