package com.itwill.post.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.datasource.HikariDataSourceUtil;
import com.itwill.post.model.Post;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.servlet.jsp.jstl.sql.Result;

// Repository(Persistance) Layer(저장소/영속성 계층)
// DB CRUD(Create Read Update Delete)작업을 수행하는 계층.

public class PostDao {

    //SLF4J 로깅 기능 사용:
    
    private static final Logger log = LoggerFactory.getLogger(PostDao.class);
    
    private static PostDao instance;
    private List<Post> list;
    private HikariDataSource ds;
    
    private PostDao() {
        
        ds = HikariDataSourceUtil.getinstance().getDataSource();
        
    }

    public static PostDao getinstance() {
        if (instance == null) {

            instance = new PostDao();

        }

        return instance;

    }
    
    public Post recordToPost(ResultSet rs) throws Exception {
        long id = rs.getLong("id");
        String title = rs.getString("title");
        String content = rs.getString("content");
        String author = rs.getString("author");
        LocalDateTime created_time = rs.getTimestamp("created_time").toLocalDateTime();
        LocalDateTime modified_time = rs.getTimestamp("modified_time").toLocalDateTime();
        
        Post post = new Post(id, title, content, author, created_time, modified_time);
                
        
        return post;
    }
    
    // Post 테이블에서 전체 레코드를 id 내림차순으로 정렬해서 검색.
    private static final String SQL_SELECT_ALL = "SELECT * FROM POST ORDER BY ID desc";
    // 최근 작성된 포스트 먼저 확인
    
    public List<Post> read(){
        list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            
            log.info(SQL_SELECT_ALL);
            while(rs.next()) {
                
                Post post = recordToPost(rs);
                        
                list.add(post);
            }
            log.info("list size = {}",list.size());
            log.info("#.of rows = {}",list.size());
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            
            
        }
        
        
        return list;
        
    }
    private static final String SQL_WRITE = "INSERT INTO POST (title, content, author) VALUES (?,?,?)";
    
    public int write(Post post) {
        log.info("write({})",post);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_WRITE);
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setString(3, post.getAuthor());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
        return result;
        
    }
    private static final String SQL_READ_ONE = "SELECT * FROM POST WHERE id = ?";
    
    public Post read(int id) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Post post = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_READ_ONE);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while(rs.next()) {
                
                post = recordToPost(rs);
                
                
            }
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            
            
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        log.info(post.toString());
        return post;
    }
    

}
