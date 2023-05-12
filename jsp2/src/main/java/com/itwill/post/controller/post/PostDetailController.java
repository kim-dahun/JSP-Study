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
 * Servlet implementation class PostDetail
 */
@WebServlet(name="detail", urlPatterns = {"/post/detail"})
public class PostDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final Logger log = LoggerFactory.getLogger(PostDetailController.class);   
    private PostService postService = PostService.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    log.info("doget()");
	    
	    Long id = Long.parseLong((request.getParameter("id")));
	    
		Post post = postService.read(id);
		
		request.setAttribute("post", post);
	    
	    request.getRequestDispatcher("/WEB-INF/post/postDetail.jsp").forward(request, response);
	    
	}

	

}
