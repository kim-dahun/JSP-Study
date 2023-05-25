package com.itwill.spring2.dto;

import com.itwill.spring2.domain.Reply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyUpdateDto {

    private String replyText;

    public Reply toEntity(long id) {
        
        Reply reply = Reply.builder().id(id).reply_text(replyText).build();
        
        return reply;
    }
    
}
