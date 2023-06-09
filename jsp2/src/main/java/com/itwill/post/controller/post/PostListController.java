package com.itwill.post.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.Post;
import com.itwill.post.service.PostService;

/**
 * Servlet implementation class Post
 */
@WebServlet(name="post", urlPatterns = "/post")
public class PostListController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private final PostService postservice = PostService.getInstance();
	private static final Logger log = LoggerFactory.getLogger(PostListController.class);
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("postListController.doGet()");
	    log.info("doget()");
	    List<Post> posts = postservice.read();
	    
	    // 포스트 목록을 JSP에게 전달
		request.setAttribute("postlist", posts);
	    request.getRequestDispatcher("/WEB-INF/post/postlist.jsp").forward(request, response);
	    
	}


	


}
