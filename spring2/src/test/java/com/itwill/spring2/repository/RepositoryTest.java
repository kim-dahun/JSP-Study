package com.itwill.spring2.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.itwill.spring2.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        locations = {"file:src/main/webapp/WEB-INF/application-context.xml"}
        
        )
public class RepositoryTest {

    @Autowired
    private PostRepository postRepository;
    
//    @Test
    public void testDelteById() {
        
        int result = postRepository.deleteById(3);
        Assertions.assertEquals(1, result);
        log.info("delete rowcount = {}",result);
    }
    
    @Test
    public void testUpdateTitleAndContent() {
        Post post = postRepository.selectById(41);
        Assertions.assertNotNull(post);
        log.info("post = {}",post);
        post = Post.builder().id(41).title("스프링프레임워크-마이바티스").content("MyBatis를 사용한 DB 업데이트").build();
        Assertions.assertNotNull(post);
        log.info("post = {}",post);
        post.setContent("스프링테스트 후 수정한 데이터");
        post.setTitle("스프링테스트를 위해 제목 수정");
        int result = postRepository.updateTitleAndContent(post);
        log.info("Update RowCount = {}",result);
        
    }
    
//    @Test
    public void testSelectById() {
        
        Post post = postRepository.selectById((long) 1);
        Assertions.assertNotNull(post);       
        log.info(post.toString());
        
        post = postRepository.selectById((long) -1);
        Assertions.assertNull(post);
        log.info("post={}",post);
    }
    
//    @Test
    public void testSelectOrderByIdDesc() {
        List<Post> list = postRepository.selectOrderByIdDesc();
        log.info("list = {}",list);
        for(Post p : list) {
            
            log.info(p.toString());
        }
        
        
        
    }
    
//    @Test
    public void testPostRepository() {
        
        Assertions.assertNotNull(postRepository);
        log.info("postRepository = {}" , postRepository);
        
        Post post = Post.builder().title("MyBatis 테스트").content("MyBatis를 이용한 insert 테스트").author("admin").build();
        log.info(post.toString());
    
        int result = postRepository.insert(post);
        Assertions.assertEquals(1, result);
        log.info("result = {}",result);
        
        
    }
    
    
}
