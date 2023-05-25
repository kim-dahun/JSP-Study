package com.itwill.spring2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.spring2.domain.Reply;
import com.itwill.spring2.dto.ReplyCreateDto;
import com.itwill.spring2.dto.ReplyReadDto;
import com.itwill.spring2.dto.ReplyUpdateDto;
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
        log.info("create(dto={})", dto);

        return replyRepository.insert(dto.toEntity());
    }

    public List<ReplyReadDto> read(long id) {

        log.info("read(id= {})", id);

        List<Reply> list = replyRepository.selectByPostId(id);

        return list.stream().map(ReplyReadDto::fromEntity).toList();

    }

    public int delete(long id) {

        log.info("delete(id={})", id);

        return replyRepository.delete(id);

    }

    public ReplyReadDto selectById(long id) {
        
        log.info("selectById(id = {})",id);
        
        Reply reply = replyRepository.selectById(id);
        // TODO Auto-generated method stub
        
        ReplyReadDto dto = ReplyReadDto.fromEntity(reply);
        
        return dto;
    }
    
    public int update(long id, ReplyUpdateDto dto) {
        
        log.info("update({},{})",id,dto);
        
        Reply reply = dto.toEntity(id);
        
        int result = replyRepository.update(reply);
        
        
        return result;
    }

}
