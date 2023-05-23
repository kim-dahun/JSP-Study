package com.itwill.spring2.service;

import org.springframework.stereotype.Service;

import com.itwill.spring2.dto.ReplyCreateDto;
import com.itwill.spring2.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 초기화하는 생성자
@Service // Spring Context 에 Service 컴포넌트 객체로 등록
public class ReplyService {

    private final ReplyRepository replyRepository;

    public int create(ReplyCreateDto dto) {
        // TODO Auto-generated method stub
        log.info("create(dto={})",dto);
        
        return replyRepository.insert(dto.toEntity());
    }
    
    
    
}
