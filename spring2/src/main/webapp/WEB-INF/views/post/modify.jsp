<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
                   <h1>포스팅 수정하기</h1> 
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
                        <li class="nav-item">
                            <c:url var="postdetail" value="/post/details">
                                <c:param name="id" value="${post.id }"></c:param>
                            </c:url>
                            <a class="nav-link" href="${ postdetail }">포스트 상세보기</a>
                        </li>
                    </ul>
                </nav>
                <main class="my-2">
                    <div class="card">
                        <form id="modifyform" class="card-body">
                            <div class="my-2">
                                <label class="form-label for="id">번호</label>
                                <input class="form-control" id="id" name="id" value="${ post.id }" readonly="readonly"/>
                            </div>
                            <div class="my-2">
                                <label class="form-label for="title">제목</label>
                                <input class="form-control" name="title" id="title" value="${post.title }" />
                                
                            </div>
                            <div class="my-2">
                                <label class="form-label for="content">내용</label>
                                <textarea class="form-control" name="content" id="content"  >${post.content }</textarea>
                            </div>
                            <div class="my-2">
                                <label class="form-label for="author">작성자</label>
                                <input class="form-control" id="author" value="${post.author }" readonly="readonly"/>
                            </div>
                            
                            
                        </form>
                        <div class="card-footer my-2">
                        <div class="my-2">
                            
                            <button id="btn_Update" class="form-control btn btn-outline-success">수정완료</button>
                            </div>
                            <div>
                                
                            <button id="btn_Delete" class="form-control btn btn-outline-danger">삭제하기</button>
                            </div>
                        </div>
                    </div>
                </main>
                
            </div>
            
        <script src="../static/js/modifyJs.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        
	</body>
</html>