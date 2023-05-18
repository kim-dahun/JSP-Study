<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>spring 2</title>
</head>
<body>
    <header>
        <h1 class="display-1 text-center border border-black" >포스트 목록 보기</h1>
    </header>
    <nav class="nav nav-tabs border border-black">
        <ul class="nav nav-tabs">
            <li class="nav-items">
                <c:url var="mainPage" value="/" />
                <a class="nav-link" href="${ mainPage }">메인 페이지</a>
            </li>
            <li class="nav-items">
                <c:url var="postCreatePage" value="/post/create" />
                <a class="nav-link" href="${postCreatePage }">새 포스트 작성</a>
            </li>
        </ul>
    </nav>
    <main>
        <div>
            <table class="table table-striped text-center">
                <thead>
                    <tr>
                        <th>게시글No</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성시간</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ postlist }" var="postlist">
                        <tr>
                            <td>${ postlist.id }</td>
                            <td>${ postlist.title }</td>
                            <td>${ postlist.author }</td>
                            <td>${ postlist.created_time }</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>