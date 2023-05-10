<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PostList</title>
</head>
<body>
    <h1>포스트 목록 Page</h1>

    <nav>
        <ul>
            <li>
                <%-- 상대경로에서 현재 폴더(./) 의 의미 : context root 까지의 주소
        http://localhost:8081/post/ --%> 
                <c:url var="mainpage" value="/"></c:url>
                <a href="${mainpage}">메인 페이지</a>
            </li>
            <li>
                <c:url var="postCreate" value="/post/create"></c:url>
                <a href="${postCreate}">새 글 작성</a>
            </li>
        </ul>
    </nav>
</body>
</html>