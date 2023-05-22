package com.itwill.spring2.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 댓글 테이블(Replies)에 저장되는 레코드(행 1개) 를 표현하는 객체.

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reply {

    
    private long id; // 댓글의 번호(댓글 id) primary key
    private long post_id; // 포스트 아이디 (외래키)
    private String reply_text; // 댓글 내용
    private String writer; // 댓글 작성자
    private LocalDateTime created_time; // 최초 작성시간
    private LocalDateTime modified_time; // 최종 수정시간
    
}
