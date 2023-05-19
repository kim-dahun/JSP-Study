<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
		<title>Spring 2</title>
	</head>
        
	<body>
		
            <div class="container-fluid">
                <header class="my-2 p-5 text-center text-bg-secondary">
                   <h1>페이지 상세보기</h1> 
                </header>
                <nav class="nav-tabs navbar navbar-expand-lg bg-body-light">
                    <ul class="navbar-nav bg-light">
                        <li class="nav-item">
                            <c:url var="mainPage" value="/"/>
                            <a class="nav-link" href="${mainPage }">메인 페이지</a>
                        </li>
                        <li class="nav-item">
                            <c:url var="postlist" value="/post/list">
                                <c:param name="num" value="0"></c:param>
                            </c:url>
                            <a class="nav-link" href="${postlist }">포스트 목록</a>
                        </li>
                    </ul>
                </nav>
                <main class="my-2">
                    <div class="card">
                        <form class="card-body">
                            <div class="my-2">
                                <label class="form-label for="id">번호</label>
                                <input class="form-control" id="id" name="id" value="${ post.id }" readonly="readonly"/>
                            </div>
                            <div class="my-2">
                                <label class="form-label for="title">제목</label>
                                <input class="form-control" id="title" name="title" value="${post.title }" readonly="readonly"/>
                                
                            </div>
                            <div class="my-2">
                                <label class="form-label for="content">내용</label>
                                <textarea class="form-control" id="content" name="content" readonly="readonly" >${post.content }</textarea>
                            </div>
                            <div class="my-2">
                                <label class="form-label for="author">작성자</label>
                                <input class="form-control" id="author" name="author" value="${post.author }" readonly="readonly"/>
                            </div>
                            <div class="my-2">
                                <fmt:formatDate value="${post.createdTime }" var="createdTime" pattern="yyyy-MM-dd HH:mm"/>
                                <label class="form-label for="createdTime">최초 작성 시간</label>
                                <input class="form-control" id="createdTime" name="createdTime" readonly="readonly" value="${ createdTime }"/>
                            </div>
                            <div class="my-2">
                            <fmt:formatDate value="${post.modifiedTime }" var="modifiedTime" pattern="yyyy-MM-dd HH:mm"/>
                                <label class="form-label for="modifiedTime">최종 수정 시간</label>
                                <input class="form-control" id="modifiedTime" name="modifiedTime" readonly="readonly" value="${ modifiedTime}" />
                            </div>
                            
                        </form>
                        <div class="card-footer my-2">
                            <c:url var="postModifyPage" value="/post/modify">
                                <c:param name="id" value="${post.id }" />
                            </c:url>
                            <a href="${postModifyPage }"><button class="form-control btn btn-outline-primary">수정하기</button></a>
                        </div>
                    </div>
                </main>
                
            </div>
            
        
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	</body>
</html>