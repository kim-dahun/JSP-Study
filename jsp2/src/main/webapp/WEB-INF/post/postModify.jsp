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
            <h1> 포스트 수정 페이지 </h1>
        </header>
        <nav>
            <c:url var="postlist" value="/post"></c:url>
        
            <c:url var="mainpage" value="/"></c:url>
            <c:url var="postdetail" value="/post/detail">
                <c:param name="id" value="${post.id }" />
            </c:url>
            <ul>
            <!-- 로그인한 username이 있는 경우 -->
            <c:if test="${ not empty signedInUser }">
                <li>
                
                    <span>${signedInUser}</span>
                    <c:url var="signOut" value="/user/signout"></c:url>
                    <a href="${signOut }">로그아웃</a>
                </li>
                
            </c:if>
            
                <li><a href= "${mainpage }">메인 메뉴</a></li>
                <li><a href="${postlist}">포스트 목록</a></li>
               
                <li><a href="${postdetail }">상세 보기</a></li>
            </ul>
        </nav>
        <main>
            <form id="postModifyForm" >
            <div><input id = "id" type="text" value="${post.id}" readonly="readonly" name="id"/></div>
            <div><input id = "title" type="text" value="${post.title}" autofocus="autofocus" name="title"/></div>
            <hr />
            <div>
               <textarea id="content" rows="5" cols="70" name="content" >${post.content }</textarea>
            </div>
            <hr />
            <div>
                <input type="text" value = "${post.author}" readonly="readonly" />
            </div>
            <c:if test="${signedInUser == post.author }">
            <div>
                <button id = "btnUpdate" style="padding: 0px 15px;">수정</button>
                <button id = "btnDelete" style="padding: 0px 15px;">삭제</button>
            </div>
            </c:if>
            </form>
        </main>
        
        <script src="../js/postModify.js"></script>
            
        
    </body>
</html>