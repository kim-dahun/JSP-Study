package com.itwill.spring2.dto;

import java.sql.Timestamp;

import com.itwill.spring2.domain.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class PostListDto {
    private long id;
    private String title;
    private String author;
    private Timestamp createdTime; // JSTL 에서는 LocalDateTime 객체를 사용하지 못하기 때문에 Timestamp 타입으로 선언.
    
    
    public static PostListDto fromEntity(Post entity) {
        
        return PostListDto.builder().id(entity.getId()).author(entity.getAuthor()).title(entity.getTitle()).createdTime(Timestamp.valueOf(entity.getCreated_time())).build();
        
    }
    
}
