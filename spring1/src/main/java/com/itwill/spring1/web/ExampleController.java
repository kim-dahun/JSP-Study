package com.itwill.spring1.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import lombok.extern.slf4j.Slf4j;

// POJO(Plain Old Java Object) :
/* 평범한 자바 객체.
 * 특정 클래스를 상속해야만 하거나, 상속 후 메서드들을 Override해야만 하는 클래스가 아닌 클래스
 * 스프링 프레임워크는 POJO로 작성된 클래스를 Controller로 이용 가능
 * 
 */


@Slf4j // Logger 객체(log)를 생성.
@Controller // Spring MVC 컴포넌트 애너테이션(@Component, @Controller, @service, @repository, ...) 중 하나. 
//Controller 컴포넌트라는 것을 DispatcherServlet 에게 알려줌.
public class ExampleController {

    @GetMapping("/") // GET 방식의 요청 주소가 "/"(Context Root)인 요청을 처리하는 메서드.
    public String home(Model model) {
        
        log.info("home()");
        
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("now", now);
        
        return "index"; // View의 이름
        
    }
    
    @GetMapping("/ex1")
    public void ex1() {
        log.info("example1() 호출");
        
        // Controller 메서드가 Void 인 경우(View의 이름을 Return 하지 않는 경우)
        
        // 요청주소의 이름이 View의 이름.
        
        
    }
    
    
}
