package com.itwill.spring2.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.itwill.spring2.domain.Reply;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(
            SpringExtension.class
        )
@ContextConfiguration(
        locations = {"file:src/main/webapp/WEB-INF/application-context.xml"}
        )

public class ReplyRepositoryTest {

    
    // Repository 객체를 주입받기
    @Autowired
    private ReplyRepository replyRepository;
    
//    @Test
    public void testselectByPostID() {
        Assertions.assertNotNull(replyRepository);
        log.info(replyRepository.toString());
        
        
        List<Reply> list = new ArrayList<>();
        
        list = replyRepository.selectByPostId(1);
        Assertions.assertNotNull(list);
        for(Reply x : list) {
            log.info(x.toString());
            
            
        }
        
        
    }
    @Test
    public void testSelectCase() {
        
        long result = replyRepository.selectReplyCountWithPostId(2);
        log.info("result = {}",result);
        
    }
    
//    @Test
    public void testDelete() {
        
        int result = replyRepository.delete(1);
        log.info("result = {}",result);
        
    }
    
//    @Test
    public void testUpdate() {
        
        Assertions.assertNotNull(replyRepository);
        log.info(replyRepository.toString());
        
        Reply reply = Reply.builder().id(1).reply_text("수정한 댓글입니다 -- TEST").build();
        log.info(reply.toString());
        
        int result = replyRepository.update(reply);
        log.info("result = {}",result);
       
        
        
    }
    
    
//    @Test
    public void testInsert() {
        Assertions.assertNotNull(replyRepository);
        log.info(replyRepository.toString());
        Reply reply = Reply.builder().post_id(2).reply_text("2답글 달았습니다.").writer("guest").build();
        log.info(reply.toString());
        
        
        int result = replyRepository.insert(reply);
        log.info("result = {}",result);
        
        
    }
    
    
}
