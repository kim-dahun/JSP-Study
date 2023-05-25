package com.itwill.spring2.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring2.domain.Reply;
import com.itwill.spring2.dto.ReplyCreateDto;
import com.itwill.spring2.dto.ReplyReadDto;
import com.itwill.spring2.dto.ReplyUpdateDto;
import com.itwill.spring2.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reply")
public class ReplyController {

    
    private final ReplyService replyService;
    
    @PostMapping
    public ResponseEntity<Integer> createReply(@RequestBody ReplyCreateDto dto){
        log.info("createReply(dto = {})",dto);
        
        int result = replyService.create(dto);
        
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/all/{postId}") // 경로변수 이름이랑 똑같이 맞추기
    public ResponseEntity<List<ReplyReadDto>> read(@PathVariable long postId) {
        log.info("read(postId= {})",postId);
        
        List<ReplyReadDto> list = replyService.read(postId);
        log.info("# of replies = {}",list.size());
        return ResponseEntity.ok(list);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable long id){
        log.info("delete(id= {})",id);
        
        int result = replyService.delete(id);
        
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ReplyReadDto> selectById(@PathVariable long id){
        log.info("selectById()");
        
        ReplyReadDto dto = replyService.selectById(id);
        log.info("dto={}",dto);
        return ResponseEntity.ok(dto);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateReply(@PathVariable long id, @RequestBody ReplyUpdateDto dto){
        
        log.info("updateReply=(id={}, dto={})",id,dto);
        
        int result = replyService.update(id, dto);
        
        return ResponseEntity.ok(result);
    }
    
//    @Data
//    @AllArgsConstructor
//    public class Test{
//        private int age;
//        private String name;
//        
//        
//        
//    }
//    
//    @GetMapping
//    public ResponseEntity<Test> hello() {
//        log.info("hello()");
//        
//        
//        return ResponseEntity.ok(new Test(16,"ohte")) ;
//        
//    }
    
    
}
