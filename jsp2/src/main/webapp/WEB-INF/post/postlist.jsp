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
    <main>
    <table style="font-size: xx-large; border: 1px solid black; border-collapse: collapse;">
        <thead>
            <tr>
            <th>글 번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>최종수정시간</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${postlist}" var="post">
            <tr>
            <td style="text-align:center; font-size: xx-large; border: 1px solid black; border-collapse: collapse;">${post.id}</td>
            <td style="font-size: xx-large; border: 1px solid black; border-collapse: collapse;">
            <c:url var="postDetail" value="/post/detail">
                <c:param name="id" value="${post.id }"></c:param>
            </c:url>
            <a href="${postDetail}">${post.title}</a>
            
            </td>
            <td style="font-size: xx-large; border: 1px solid black; border-collapse: collapse;">${post.author}</td>
            <td style="font-size: xx-large; border: 1px solid black; border-collapse: collapse;">${post.modifiedTime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:url var="searchPage" value="/post/search"></c:url>
    <form action="${searchPage}">
        <select name="category">
            <option value="t">제목</option>
            <option value="c">내용</option>
            <option value="tc">제목 + 내용</option>
            <option value="a">작성자</option>
        </select>
        <input type="text" name="keyword" placeholder="검색어 입력" required autofocus />
        <input type="submit" value="검색" />
    </form>
    
        <a href="/post/post"><button>새로고침</button></a>
    
    </main>
     
</body>
</html>