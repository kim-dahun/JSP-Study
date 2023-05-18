package com.itwill.spring2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.spring2.domain.Post;
import com.itwill.spring2.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// application-context.xml 에서 <context:component-scan> 설정에서
// com.itwill.spring2.service 패키지와 그 하위 패키지를 스캔(검색)

@Service //-> Spring Container 에서 Service Component 객체를 생성하고 관리(필요한 곳에 주입).
@RequiredArgsConstructor // 2. (2) final로 선언된 필드를 초기화하는 생성자.
@Slf4j
public class PostService {

    // 의존성 주입(DI: Dependency Injection) :
    // 1. 필드에 의한 의존성 주입 - @Autowired 애너테이션 사용
    // 2. 생성자에 의한 의존성 주입
    //  (1) Field를 Final로 선언
    //  (2) Final 변수를 초기화 할 수 있는 생성자를 작성
    
//    @Autowired private PostRepository postRepository // 1. 필드에 의한 의존성 주입
    
    private final PostRepository postRepository; // 2. (1) 생성자에 의한 의존성 주입
    
    // 포스트 목록 페이지
    public List<Post> read(){
        log.info("read()");
        
        return postRepository.selectOrderByIdDesc();
    }
    
    // 포스트 상세보기 페이지
    public Post read(long id) {
        log.info("read({})",id);
        
        return postRepository.selectById(id);
    }
    
    // 새 포스트 작성 페이지
    public int write(Post post) {
        log.info("write({})",post);
        
        return postRepository.insert(post);
    }
    
    // 포스트 업데이트
    public int update(Post post) {
        
        log.info("update({})",post);
        
        return postRepository.updateTitleAndContent(post);
    }
    
    // 포스트 삭제
    public int delete(long id) {
        
        log.info("delete({})",id);
        
        return postRepository.deleteById(id);
        
    }
    
}
