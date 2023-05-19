package com.itwill.spring2.dto;

import java.sql.Timestamp;

import com.itwill.spring2.domain.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PostDetailDto {
    
    private long id;
    private String title;
    private String content;
    private String author;
    private Timestamp createdTime;
    private Timestamp modifiedTime;
    
    public static PostDetailDto fromEntity(Post post) {
        PostDetailDto dto = PostDetailDto.builder().id(post.getId()).title(post.getTitle()).content(post.getContent()).author(post.getAuthor()).createdTime(Timestamp.valueOf(post.getCreated_time())).modifiedTime(Timestamp.valueOf(post.getModified_time())).build();     
        
        return dto;
    }
    
}
