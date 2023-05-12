package com.itwill.post.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.Post;
import com.itwill.post.service.PostService;

/**
 * Servlet implementation class PostUpdateController
 */
@WebServlet(name="postUpdateController",urlPatterns = {"/post/update"}) // "/" context루트 밑으로.
public class PostUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = LoggerFactory.getLogger(PostUpdateController.class);
   
	private PostService postService = PostService.getInstance();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    log.info("doPost()");
	    
	    // 요청 파라미터(id,title,content)의 값들을 찾음.
	    long id = Long.parseLong(request.getParameter("id"));
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    
	    Post post = new Post(id, title, content, null, null, null);
	    log.info("수정할 포스트 = {}",post);
	    
	    int result = postService.update(post);
	    log.info("포스트 업데이트 결과 = {}",result);
	    // 수정 후 상세 보기 페이지로
	    response.sendRedirect("/post/post/detail?id="+id);
	    
	}

}
