package com.itwill.spring2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.OracleDriver;

@Slf4j
@ExtendWith(SpringExtension.class) // Spring Junit 테스트를 실행하는 메인 클래스
@ContextConfiguration(
        
            locations = {"file:src/main/webapp/WEB-INF/application-context.xml"}
        ) // Spring Context 환경 설정 파일의 경로와 이름
public class jdbcTest {

    @Test // JUnit 테스트 메서드
    public void testOjdbc() throws Exception {
        
        // JDBC 1: JDBC Library 등록
        DriverManager.registerDriver(new OracleDriver());
        log.info("OracleJdbc 드라이버 등록 성공");
        
        // JDBC 2: Connection 객체 생성
        final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
        
        final String username = "scott";
        
        final String password = "tiger";
        
        Connection conn = DriverManager.getConnection(URL, username, password);
        Assertions.assertNotNull(conn);
        //-> 단위 테스트 성공 조건 : Connection 객체가 Null 이 아님
        
        log.info("conn = {}",conn);
        
        // JDBC 3. 사용했던 Resource 해제
        
        conn.close();
        log.info("Connection close 성공");
        
        
    }
    
}
