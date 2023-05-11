package com.itwill.post.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.Post;
import com.itwill.post.service.PostService;

/**
 * Servlet implementation class PostCreate
 */
@WebServlet(name="postCreate", urlPatterns = "/post/create")
public class PostCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger log = LoggerFactory.getLogger(PostCreateController.class);
	
	private final PostService postService = PostService.getInstance();
	
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("doget()");
	    request.getRequestDispatcher("/WEB-INF/post/postCreate.jsp").forward(request, response);
	    
	}

	/**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    log.info("dopost()");
	    
	    
	    //TODO: 요청에 포함된 요청 파라미터 정보들을 추출. 
	    // getParameter() 의 argument는 form의 input, textarea 의 Name 속성값
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    String author = request.getParameter("author");
	    
	    Post post = new Post(0,title,content,author,null,null);
	    //TODO: 서비스 계층의 메서드를 호출해서 DB에 포스트를 저장.
	    int result = postService.create(post);
	    
	    log.info(result + " 개 행 추가");
	    // 포스트 목록 페이지로 이동(redirect)
	    
	    response.sendRedirect("/post/post"); // 요청주소 : /contextRoot/path
	    
	    // PRG(Post-Redirect-Get)패턴.
	    
	}

}
