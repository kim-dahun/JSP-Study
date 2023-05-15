package com.itwill.post.model;

// MVC 아키텍쳐에서 Model에 해당하는 클래스. VO(Value Object)
public class User {

    private long id; // Primary Key
    private String username; // Login Id
    private String password; // Login Password
    private String email;
    private long point;
    
    public User() {
        
    }

    public User(long id, String username, String password, String email, long point) {
        
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.point = point;
    }
    
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("User [ id = %d, username = %s, password = %s, email = %s, point = %d ]", id,username,password,email,point);
    }
    
}
