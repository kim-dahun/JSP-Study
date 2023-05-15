package com.itwill.post.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.datasource.HikariDataSourceUtil;
import com.itwill.post.model.User;
import com.zaxxer.hikari.HikariDataSource;

//Repository(Persistance) 계층
public class UserDao {

    // Users 테이블과 연결하여 DB를 호출하는 클래스
    private static final Logger log = LoggerFactory.getLogger(UserDao.class);
    
    // Singleton 패턴
    private static UserDao instance = null;
    
    private final HikariDataSource ds; // Connection Pool 객체
    
    private UserDao(){
        this.ds = HikariDataSourceUtil.getinstance().getDataSource();
                
    }
    
    public static UserDao getInstance() {
        
        if (instance == null) {

            instance = new UserDao();

        }

        return instance;
    }

    // 로그인 시 사용할 SQL:
    private static final String SQL_SELECT_BY_USERNAME_PASSWORD = "SELECT * FROM users WHERE username = ? AND password = ?";

    // argument user 객체의 username과 password가 일치하는 정보를 찾으면 Null이 아닌 값,
    // 일치하는 정보를 찾을 수 없으면 NULL 리턴.
    public User selectByUsernameAndPassword(User user) {
        log.info("selectByUsernameAndPassword({})", user);
        log.info(SQL_SELECT_BY_USERNAME_PASSWORD);
        User result = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_USERNAME_PASSWORD);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            rs = stmt.executeQuery();
            String id = "";
            String pw = "";
            if (rs.next()) { // 일치하는 행이 있으면
                result = recordToUser(rs);

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            try {
                
                
                
                
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return result;

    }

    private User recordToUser(ResultSet rs) throws Exception {
        // TODO Auto-generated method stub
        

        long id = rs.getLong("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String email = rs.getString("email");
        long point = rs.getLong("point");
        
        User user = new User(id, username, password, email, point);
        
        return user;
    }

}
