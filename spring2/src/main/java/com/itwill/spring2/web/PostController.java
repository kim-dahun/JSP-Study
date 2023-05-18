package com.itwill.spring2.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.spring2.domain.Post;
import com.itwill.spring2.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller // DispatcherServlet 에게 Controller Component로 등록.
@Slf4j // Log출력
@RequiredArgsConstructor // 생성자에 의한 의존성 주입
@RequestMapping("/post") // PostController 클래스의 메서드들은 요청 주소가 "/post"로 시작.
public class PostController {

    private final PostService postService; // 생성자에 의한 의존성 주입

    @GetMapping("/list") // GET 방식의 /post/list 요청 주소를 처리하는 메서드
    public void list(Model model) {
        log.info("list()");
        // 리턴 값이 없는 경우 View의 이름은 요청주소와 동일
        // /WEB-INF/views/post/list.jsp
        
        // Controller 는 Service 계층의 메서드를 호출해서 서비스 기능 수행.
        List<Post> list = postService.read();
        
        
        model.addAttribute("postlist",list);
    }
}
