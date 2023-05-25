package com.itwill.spring2.repository;

import java.util.List;

import com.itwill.spring2.domain.Reply;

public interface ReplyRepository {

    List<Reply> selectByPostId(long postId);
    
    Reply selectById(long id);
    
    int insert(Reply reply);
    
    int update(Reply reply);
    
    int delete(long id);
    
    long selectReplyCountWithPostId(long PostId);
}
