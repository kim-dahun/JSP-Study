package com.itwill.post.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.service.PostService;

/**
 * Servlet implementation class PostDeleteController
 */
@WebServlet(name = "postDeleteController", urlPatterns = {"/post/delete"})
public class PostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PostDeleteController.class);
	private PostService postService = PostService.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */





	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("dopost()");
		
		// 요청 parameter 중 삭제할 글 번호 찾음
	    long id = Long.parseLong(request.getParameter("id"));
		log.info("id={}",id);
		
		// 서비스 계층의 메서드를 사용해서 Post를 삭제
		int result = postService.delete(id);
	    log.info("포스트 삭제 결과 = {}",result);
	    
	    // Postlist 페이지로 이동. Redirect
		response.sendRedirect("/post/post");
		
	}

}
