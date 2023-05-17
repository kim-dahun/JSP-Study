package com.itwill.spring1.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.spring1.dto.UserDto;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;
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
    
    @GetMapping("/ex2")
    public void getParamEx(@RequestParam(name="username") String username,@RequestParam(name="age") int age1, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("age", age1);
        log.info("getParamEx(username = {}, age = {})",username,age1);
        
        
        
        
        
    }
    
    
    @PostMapping("/ex3")
    public String getParamEx2(HttpServletRequest request,@RequestParam(name="username") String name, @RequestParam(defaultValue = "0") int age) {
        
        log.info("getParamEx2()");
        request.setAttribute("username", name);
        request.setAttribute("age", age);
        
        
        return "ex2";
        
    }
    
    @GetMapping("/ex4")
    public String getParamEx3(UserDto user) {
        
        log.info("getParamEx3(user = {})",user);
        // DispatcherServlet은 컨트롤러의 메서드를 호출하기 위해서,
        // 1. 요청 파라미터들을 분석(request.getParameter()).
        // 2. UserDto의 기본 생성자를 호출해서 객체를 생성.
        // 3. 요청 파라미터들의 이름으로 UserDto의 setter 메서드를 찾아서 호출.
        // 4. UserDto 객체를 컨트롤러 메서드를 호출할 때 argument로 전달.
        
        
        return "ex2";
    };
    
    @GetMapping("/sample")
    public void sample() {
        log.info("sample()");
        
    }
    
    @GetMapping("/forward")
    public String forwardTest() {
        
        log.info("forwardTest()");
        
        // Controller 메서드에서 다른 페이지로 Forward하는 방법
        // "forward:" 으로 시작하는 문자열을 리턴하면,
        // DispatcherServlet은 리턴값이 뷰의 이름이 아니라 포워드 이동할 페이지 주소로 인식.
        return "forward:/sample";
    }
    
    @GetMapping("/redirect")
    public String redirectTest(RedirectAttributes attrs) {
        log.info("redirectTest()");
        
        // 컨트롤러 메서드에서 리다이렉트되는 페이지까지 유지되는 정보를 저장할 때
        attrs.addFlashAttribute("redAttr", "테스트");
        
        // 컨트롤러 메서드에서 다른 페이지(요청 주소)로 Redirect 하는 방법 :
        // "Redirect:" 으로 시작하는 문자열을 리턴하면,
        // DispatcherServlet 은 리턴값이 뷰의 이름이 아니라 리다이렉트 이동할 페이지 주소로 인식
        
        return "redirect:/sample";
        
        
    }
    
}
