package com.itwill.spring2.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.itwill.spring2.domain.Reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyReadDto {

    private long id; // 댓글의 번호(댓글 id) primary key
    private long post_id; // 포스트 아이디 (외래키)
    private String replyText; // 댓글 내용
    private String writer; // 댓글 작성자
    
    private Timestamp modifiedTime; // 최종 수정시간
    
    public static ReplyReadDto fromEntity(Reply reply) {
        
        ReplyReadDto dto = ReplyReadDto.builder().id(reply.getId()).post_id(reply.getPost_id()).replyText(reply.getReply_text()).modifiedTime(Timestamp.valueOf(reply.getModified_time())).writer(reply.getWriter()).build();
        
        return dto;
    }
    
}
