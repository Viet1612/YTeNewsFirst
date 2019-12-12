package ytebnews.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ytebnews.utils.Constant;


/**
 * Servlet implementation class LogoutController
 */
@WebServlet(value = { Constant.LOGOUT_URL })
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			// Xóa session
			session.invalidate();
			// Chuyển đến MH login
			RequestDispatcher dispatch = request.getServletContext().getRequestDispatcher(Constant.LOGIN_ADMIN_JSP);
			dispatch.forward(request, response);
		} catch (Exception e) {
			System.out.println(this.getClass().getName() + "-"
					+ Thread.currentThread().getStackTrace()[1].getMethodName() + e.getMessage());
			// Chuyển đến mh lỗi
			response.sendRedirect(request.getContextPath() + Constant.SYSTEM_ERR_URL);

		}

	}


}
