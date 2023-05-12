package com.itwill.post.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.Post;
import com.itwill.post.service.PostService;

/**
 * Servlet implementation class PostSearchController
 */
@WebServlet(name = "postSearchController", urlPatterns = { "/post/search" })
public class PostSearchController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(PostSearchController.class);

    private PostService postService = PostService.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // 로그
        log.info("doget()");

        // 파라미터 받기
        String category = request.getParameter("category"); // t, c, tc, a
        String word = request.getParameter("keyword"); // 검색 내용

        // 서비스 계층에 전달

        List<Post> postlist = postService.read(category, word);

        // 완료되면 요청된 페이지로 포워딩
        request.setAttribute("postlist", postlist);

        request.getRequestDispatcher("/WEB-INF/post/postlist.jsp").forward(request, response);

    }

}
