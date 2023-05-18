package com.itwill.spring2.repository;

import java.util.List;

import com.itwill.spring2.domain.Post;

// application-context.xml에서 scan 하는 패키지에 있기 때문에
// 인터페이스를 구현하는 클래스가 MyBatis에 의해 자동으로 만들어짐.
// src/main/resource/post-mapper.xml 파일에서 설정된 id와 메서드 이름이 같으면,
// 해당 id의 sql문장을 실행하는 구현 메서드를 만들어줌.
public interface PostRepository {
    
    // 메서드 전체 이름 : com.itwill.spring2.repository.PostRepository.insert
    public int insert(Post post);
    List<Post> selectOrderByIdDesc();
    
    public Post selectById(long id);
 
    public int updateTitleAndContent(Post post);
 
    public int deleteById(long id);
}
