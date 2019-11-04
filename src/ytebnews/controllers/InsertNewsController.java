package ytebnews.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ytebnews.entities.News;
import ytebnews.logics.NewsLogic;
import ytebnews.logics.UserLogic;
import ytebnews.logics.impl.NewsLogicImpl;
import ytebnews.logics.impl.UserLogicImpl;
import ytebnews.utils.Common;
import ytebnews.utils.Constant;

/**
 * Servlet implementation class InsertNewsController
 */
@WebServlet(value = { Constant.INSERT_NEWS_URL })
@MultipartConfig
public class InsertNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getServletContext().getRequestDispatcher(Constant.INSERT_NEWS_JSP);
		dispatch.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			UserLogic userLogic = new UserLogicImpl();
			NewsLogic newsLogic = new NewsLogicImpl();
			int userId = (int) session.getAttribute(Constant.USER_ID);
			String path = Constant.LIST_NEWS_AUTHOR_URL+"?action=insertsuccess";
			if(userLogic.checkUserIdAuthor(userId)) {
				News news = getNewsInfo(request);
				news.setUserId(userId);
				newsLogic.insertNewAuthor(news);
				Common.uploadFile(request, news.getImage());
			}else {
				path = Constant.LOGOUT_URL;
			}
			response.sendRedirect(request.getContextPath() + path);
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Lấy news từ req
	 * @param request
	 * @return
	 */
	private News getNewsInfo(HttpServletRequest request) {
		News news = new News();
		String newsName = request.getParameter("title");
		System.out.println(newsName);
		String description = request.getParameter(Constant.T_DESCRIPTION);
		System.out.println(description);
		String content= request.getParameter(Constant.T_CONTENT);
		System.out.println(content);
		String image  = Common.getSalt()+".png";
		news.setNewsName(newsName);
		news.setDescription(description);
		news.setImage(image);
		news.setContent(content);
		news.setDatePost(Common.getTimeNow());
		news.setView(Constant.VIEW_DEFAULT);
		news.setApprove(Constant.APPROVE_N);
		return news;
	}

}
