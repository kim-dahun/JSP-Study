package com.itwill.jsp1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ReDirectServlet
 */
public class ReDirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RedirectServlet#doGet() 호출");
		
		// 클라이언트에서 서버로 온 요청을 "Redirect" 방식으로 페이지를 이동:
		// 최초 요청 주소가 이동하는 페이지로 변경됌.
		// 최초 요청의 Request 객체와 Response 객체가 이동하는 페이지로 전달되지 않음.
		// 같은 웹 서버만이 아니라, 다른 외부 서버의 페이지로도 이동이 가능.
		
		response.sendRedirect("example.jsp");
	}

}
