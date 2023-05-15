package com.itwill.post.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class UserSignOutController
 */
@WebServlet(name="userSignOutController", urlPatterns = {"/user/signout"})
public class UserSignOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UserSignOutController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("doget()");
		
		HttpSession session = request.getSession();
		session.invalidate(); // 세션 무효화 -> 지움 - 로그아웃
		
		response.sendRedirect("/post/user/signin");
	}

}
