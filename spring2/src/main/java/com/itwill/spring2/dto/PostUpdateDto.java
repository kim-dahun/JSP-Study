package com.itwill.spring2.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.itwill.spring2.domain.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@Getter
@AllArgsConstructor
@Builder
@ToString
public class PostUpdateDto {
    
    private long id;
    private String title;
    private String content;
    
    
    public Post toEntity() {
        
        Post post = Post
                .builder()
                .id(id)
                .title(title)
                .content(content)
                .modified_time(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime())
                .build();
                
        
        return post;
    }
    
}
