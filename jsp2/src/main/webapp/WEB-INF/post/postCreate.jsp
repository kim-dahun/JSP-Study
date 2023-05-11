<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Post</title>
	</head>
	<body>
    <header>
		<h1>새 글 작성 Page</h1>
        </header>
        
        <nav>
            <ul>
                <li>
                <%-- <c:url>에서 "/" 요청주소는 context root 까지. --%>
                    <c:url value="/" var="mainpage"></c:url>
                    <a href = "${ mainpage }">메인 Page</a>
                </li>
                <li>
                    <c:url value="/post" var="postlist"></c:url>
                    <a href = "${postlist }">포스트 목록 페이지</a>
                </li>
            </ul>
        </nav>
        <main>
            <c:url var="postCreate" value="/post/create" />
            <form action="${postCreate}" method="post">
                <div>
                        <input type="text" name="title" placeholder="제목을 입력하세요" required autofocus/>
                   </div>
                   <div>
                        <textarea rows="5" cols="100" name="content" placeholder="내용 입력" required></textarea>
                    </div>
                    <div>
                        <input type="text" name="author" placeholder="아이디 입력" required />
                        
                    </div>
                <div>
                <input type="submit" value="저장하기"/>
                </div>
            </form>
        </main>
	</body>
</html>