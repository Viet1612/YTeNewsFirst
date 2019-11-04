/**
 * Copyright(C) 2019 Tran Thanh Viet
 * NewsLogic.java, Oct 15, 2019 VietTT
 */
package ytebnews.logics;

import java.sql.SQLException;
import java.util.List;

import ytebnews.entities.News;

/**
 * @author VietTT
 *
 */
public interface NewsLogic {
	/**
	 * Lấy số lượng bản ghi thỏa mãn điều kiện tìm kiếm
	 * 
	 * @param keyName    từ tìm kiếm seach bởi name
	 * @param categoryId id của category
	 * @return số lượng bản ghi
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int getTotalNews(String keyName, int categoryId, int approve, int userId) throws ClassNotFoundException, SQLException;
	
	/**
	 * Lấy danh sách news
	 * 
	 * @param offset     offset vị trí data cần lấy nào
	 * @param limit      limit số lượng lấy
	 * @param categoryId mã category tìm kiếm
	 * @param keyName    Tên tìm kiếm
	 * @return danh sách user cần tìm
	 */
	public List<News> getListNews(int offset, int limit, int categoryId, String keyName, int approve, int userId)
			throws ClassNotFoundException, SQLException;

	/**
	 * Insert news khi người đăng add bài
	 */
	public void insertNewAuthor(News news) throws ClassNotFoundException, SQLException;
}
