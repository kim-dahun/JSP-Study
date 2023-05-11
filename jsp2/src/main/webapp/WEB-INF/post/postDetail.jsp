<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP</title>
        <style>
            nav{
                border: 1px solid black;
                text-align:center;
                font-size: x-large;
                width:500px;
                height:1000px;
                margin-left: 50px;
            }
            
            button{
            
                margin-left: 200px;
            }
        </style>
	</head>
	<body>
		<nav>
            <h2>${post.title}</h2>
            <hr />
            <div>${post.content }</div>
            <hr />
            <div>${post.author}</div>
        </nav>
        <c:url var="postlist" value="/post"></c:url>
        <a href="${postlist}"><button style="padding: 25px; font-size: large;">목록으로 돌아가기</button></a>
        
            
        
	</body>
</html>