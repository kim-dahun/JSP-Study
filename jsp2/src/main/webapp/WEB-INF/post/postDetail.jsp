<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP</title>
        <style>
            main{
                border: 1px solid black;
                text-align:center;
                font-size: x-large;
                width:500px;
                height:1000px;
                margin-left: 50px;
            }
            
            div textarea{
            
                padding-bottom: 680px;
            
            }
            
            button{
            
                margin-left: 200px;
            }
            
            #mainbutton{
                
                
            
            }
        </style>
	</head>
	<body>
        <header>
            <h1> 상세 보기 페이지 </h1>
        </header>
        <nav>
            <c:url var="postlist" value="/post"></c:url>
        
            <c:url var="mainpage" value="/"></c:url>
            <c:url var="postModify" value="/post/modify">
                <c:param name="id" value="${post.id }" />
            </c:url>
            <ul>
                <li><a href= "${mainpage }">메인 메뉴</a></li>
                <li><a href="${postlist}">포스트 목록</a></li>
               
                <li><a href="${postModify }">포스트 수정</a></li>
            </ul>
        </nav>
		<main>
            <form>
            <div><input type="text" value="${post.id}" readonly="readonly"/></div>
            <div><input type="text" value="${post.title}" readonly="readonly"/></div>
            <hr />
            <div>
               <textarea rows="5" cols="70" readonly="readonly">${post.content }</textarea>
            </div>
            <hr />
            <div>
                <input type="text" value = "${post.author}" readonly="readonly"/>
            </div>
            <div>
                <input type="text" value = "${post.createdTime }" readonly="readonly" />
            </div>
            <div>
                <input type="text" value = "${post.modifiedTime}" readonly="readonly"/>
            </div>
            </form>
        </main>
        
       
            
        
	</body>
</html>