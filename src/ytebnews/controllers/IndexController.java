package ytebnews.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ytebnews.entities.Category;
import ytebnews.entities.News;
import ytebnews.logics.CategoryLogic;
import ytebnews.logics.NewsLogic;
import ytebnews.logics.impl.CategoryLogicImpl;
import ytebnews.logics.impl.NewsLogicImpl;
import ytebnews.utils.Constant;

/**
 * Servlet implementation class IndexController
 */
@WebServlet(value = { Constant.INDEX_URL })
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CategoryLogic categoryLogic = new CategoryLogicImpl();
			NewsLogic newsLogic = new NewsLogicImpl();
			List<Category> listCategories = categoryLogic.getListCategory();
			List<News> listNewsHeader = newsLogic.getListNewsHeader(4);
			request.setAttribute("listnewsheader", listNewsHeader);
			request.setAttribute("listcategory", listCategories);
			RequestDispatcher dispatch = request.getServletContext().getRequestDispatcher(Constant.INDEX_JSP);
			dispatch.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
