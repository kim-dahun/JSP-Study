package com.itwill.jsp1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SecondServlet
 */

// 서블릿 클래스의 URL 매핑(요청주소)을 설정하는 방법:
// 1. web.xml 설정 파일에서 설정하거나,
// 2. Servlet 클래스에서 @WebServlet 애너테이션으로 설정하는 방법이 있음.
// (주의) Web.xml 과 애너테이션을 모두 설정하면 안됌.


@WebServlet(name = "secondServlet", urlPatterns = { "/ex2" })



public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
	    // 클라이언트로 보내는 응답(response)의 한글이 깨지지 않도록 하기 위해서.
	    // response.getWritter 메서드 호출 전에 컨텐트 타입 세팅
	    response.setContentType("text/html; charset=UTF-8");
	    
		PrintWriter writer = response.getWriter(); // 응답을 보낼 때 사용하는 도구
		writer.append("<!doctype html>")
		    .append("<html>")
		    .append("<body>")
		    .append("<h1>두번째 Servlet</h1>")
		    .append("<a href = './'>index page</a>")
		    .append("</body>")
		    .append("</html>");
	}

}
