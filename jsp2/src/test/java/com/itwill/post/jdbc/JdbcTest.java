package com.itwill.post.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.itwill.post.model.Post.Entity;
import static com.itwill.post.model.Post.Entity.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.itwill.post.model.Post;

import oracle.jdbc.OracleDriver;

// Junit Test(자바 단위 테스트) 를 하기 위한 클래스.
// JDBC(Java DataBase Connectivity) 테스트 - ojdbc11 라이브러리 동작 여부 테스트.
// Main 메서드 만들지 않고, Test 메서드를 작성하면,
// Junit-jupiter-engine에서 Test 메서드를 실행함.
@TestMethodOrder(OrderAnnotation.class) // -> 테스트 메서드 실행 순서를 애너테이션으로 설정함.
public class JdbcTest {

    // Oracle Database 접속 주소
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    
    // DataBase 접속 계정
    private static final String USER = "scott";
    
    // DataBase 접속 비밀번호
    private static final String PASSWORD = "tiger";
    
    private ArrayList<Post> postlist = new ArrayList<>();
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // Test 메서드 작성
    //   (0) @Test 애너테이션 사용
    //   (1) 접근 제한자 = public (2) Return type = void (3) Parameter = 없음.
    // 테스트 성공/실패 여부는 테스트 메서드 작성자가 설정.
    @Test
    @Order(2) // 두번째로 실행할 테스트 메서드
     public void testSelect() throws SQLException {
        
        // 1. jdbc 라이브러리를 DriverManager에 등록.
        DriverManager.registerDriver(new OracleDriver());
        System.out.println("JDBC 라이브러리 등록 성공");
        
        String SQLselect = String.format("SELECT * FROM %s ORDER BY %s", TBL_NAME, COL_ID);
        // 2. 등록된 JDBC 드라이버를 사용해서 DB 서버에 접속.
        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
       System.out.println("conn = " + conn);
       PreparedStatement stmt = conn.prepareStatement(SQLselect);
       Assertions.assertNotNull(conn);
        // Connection이 NUll 이 아니면 테스트 성공, 그렇지 않으면 TEST 실패.
        
        // TODO : 포스트 테이블의 전체 내용을 검색. ArrayList<Post> 만들어서 그 결과를 콘솔창에 출력.
        // ArrayList<Post>의 원소 개수는 1개임을 주장할 수 있음.
       
       ResultSet rs = stmt.executeQuery();
        
       while(rs.next()) {
           
           int id = rs.getInt(COL_ID);
           String title = rs.getString(COL_TITLE);
           String content = rs.getString(COL_CONTENT);
           String author = rs.getString(COL_AUTHOR);
           Timestamp crtime = rs.getTimestamp(COL_CREATEDTIME);
           Timestamp mdtime = rs.getTimestamp(COL_MODIFIEDTIME);
           
           LocalDateTime crt = crtime.toLocalDateTime();
           LocalDateTime mdt = mdtime.toLocalDateTime();
           
           Post post = new Post(id, title, content, author, crt, mdt);
           
           postlist.add(id-1, post);
                   
       }
       
       Assertions.assertNotEquals(0, postlist.size());
        for(Post post : postlist) {
            
            System.out.println(post);
            
        }
        // 3. 연결된 데이터 베이스와 접속을 해제.
       rs.close();
       stmt.close();
       conn.close();
       System.out.println("연결 해제 성공");
       
    }
    
    @Test // JUNIT engine 에서 호출할 테스트 메서드.
    @Order(1) // 첫번째로 실행할 메서드
    public void test() throws SQLException, IOException {
        
        // Driver 등록 -> 커넥션 -> preStmt => execute -> 결과 처리 -> 리소스 해제
        String wanna = br.readLine();
        
        if(wanna.equals("안함")) {
            
        } else {
        DriverManager.registerDriver(new OracleDriver());
        System.out.println("연결완료");
        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        
        Assertions.assertNotNull(conn);
        
        String sql = String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)", TBL_NAME,COL_TITLE,COL_CONTENT,COL_AUTHOR);
        
        
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, br.readLine());
        stmt.setString(2, br.readLine());
        stmt.setString(3, br.readLine());
        
        int a = stmt.executeUpdate();
        
        Assertions.assertNotEquals(a, 0);
        
        stmt.close();
        conn.close();
        }
    }
    
    
    
}
