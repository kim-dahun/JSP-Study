package com.itwill.post.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.Post;
import com.itwill.post.repository.PostDao;

//Service(Business) layer(서비스/비즈니스 계층)
//Repository 계층의 메서드들을 이용해서 서비스를 만듦.
public class PostService {
    
    private static PostService instance;
    // service 계층에서는 Repository 계층의 메서드 사용:
    private final PostDao postDao;
    
    private static final Logger log = LoggerFactory.getLogger(PostService.class);
    
    private PostService() {
        postDao = PostDao.getinstance();
    }
    
    public static PostService getInstance() {
        
        if(instance==null) {
            
            instance = new PostService();
            
        }
        return instance;
    }
    
    public List<Post> read() {
        log.info("read()");
        
        return postDao.read();
        
    }
    
    public int create(Post post) {
        
        log.info("create({})",post);
        
        return postDao.write(post);
    }

    public Post read(long id) {
        log.info("read(id = {})",id);
        // TODO Auto-generated method stub
        return postDao.read(id);
    }

    public int delete(Long id) {
        // TODO Auto-generated method stub
        log.info("delete(id={})",id);
        
        return postDao.delete(id);
    }

    public int update(Post post) {
        // TODO Auto-generated method stub
        log.info("update(post={})",post);
        
        return postDao.update(post);
    }

    public List<Post> read(String category, String word) {
        // TODO Auto-generated method stub
        log.info("read({})",category,word);
        
        return postDao.read(category, word);
    }
}
