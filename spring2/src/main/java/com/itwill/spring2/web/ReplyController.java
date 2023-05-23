package com.itwill.spring2.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring2.dto.ReplyCreateDto;
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
