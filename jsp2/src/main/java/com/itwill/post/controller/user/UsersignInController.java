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

import com.itwill.post.model.User;
import com.itwill.post.service.PostService;
import com.itwill.post.service.UserService;

/**
 * Servlet implementation class UsersignInController
 */
@WebServlet(name = "usersignInController", urlPatterns = {"/user/signin"})
public class UsersignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger log = LoggerFactory.getLogger(UsersignInController.class);

	private UserService userService = UserService.getInstance();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    log.info("doget()");

		request.getRequestDispatcher("/WEB-INF/user/signin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("dopost()");
		
		// 요청 파라미터에 포함된 username과 password를 읽음
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// service 계층의 메서드 호출해서 로그인 성공/실패 여부 판단.
		User user = userService.signIn(username, password);
		
		log.info("로그인 결과 : {}",user);
		
		if(user==null) { // username 또는 password가 일치하지 않는 경우 - 로그인 실패
		    // 로그인 페이지로 이동(redirect)
		    response.sendRedirect("/post/user/signin");
		    // /context-root/path?query-string // sendRedirect 는 context-root 작성
		    return; // dopost 메서드 종료
		}
		
		// 로그인 성공
		// (1) 세션(session) 에 로그인 정보를 저장.
		HttpSession session = request.getSession();
		
		// session 객체에 로그인 UserName만 저장.
		session.setAttribute("signedInUser", user.getUsername());
		
		
		// (2) 로그인 성공 후 이동 -> 메인 페이지로 이동
		response.sendRedirect("/post");
	}

}
