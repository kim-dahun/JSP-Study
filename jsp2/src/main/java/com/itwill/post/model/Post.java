package com.itwill.post.model;

import java.time.LocalDateTime;

// MVC 아키텍쳐에서 Model에 해당하는 클래스 - 데이터베이스 테이블에 매핑되는 클래스
public class Post {
    
    public static interface Entity{
        
        public static final String TBL_NAME = "POST";
        public static final String COL_ID = "ID";
        public static final String COL_TITLE = "TITLE";
        public static final String COL_CONTENT = "CONTENT";
        public static final String COL_AUTHOR = "AUTHOR";
        public static final String COL_CREATEDTIME = "CREATED_TIME";
        public static final String COL_MODIFIEDTIME = "MODIFIED_TIME";
        
        
    }
    
    
    // field
    private long id; // primary key
    private String title; // 글 제목
    private String content; // 글 내용
    private String author; // 작성자
    private LocalDateTime createdTime; // 최초 작성 시간
    private LocalDateTime modifiedTime; // 최종 수정 시간
    
    public Post() {
        
    }
    
    // constructor
    public Post(long id, String title, String content, String author, LocalDateTime createdTime,
            LocalDateTime modifiedTime) {
        
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    // getter & setter
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", createdTime="
                + createdTime + ", modifiedTime=" + modifiedTime + "]";
    }
    
    
    
    
    
    
}
