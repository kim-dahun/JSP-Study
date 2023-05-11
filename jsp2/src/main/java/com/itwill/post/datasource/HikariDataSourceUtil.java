package com.itwill.post.datasource;

import java.sql.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceUtil {
    // singleton Design
    
    private static HikariDataSourceUtil instance;
    
    private HikariDataSource ds;
    
    private HikariDataSourceUtil() {
        // HikariCP를 사용하기 위한 환경 설정 객체;
        HikariConfig config = new HikariConfig();
        
        // CP(Data Source) 을 생성하기 위한 설정들:
        config.setDriverClassName("oracle.jdbc.OracleDriver");
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        config.setUsername("scott");
        config.setPassword("tiger");
        
        ds = new HikariDataSource(config);
        
        
    }
    
    public static HikariDataSourceUtil getinstance() {
        
        if(instance==null) {
            
            instance = new HikariDataSourceUtil();
            
        }
        
        return instance;
        
    }
    
    public HikariDataSource getDataSource() {
        return ds;
        
    }
    
}
