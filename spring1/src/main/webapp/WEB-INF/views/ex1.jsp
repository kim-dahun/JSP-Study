<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ex1</title>
	</head>
	<body>
        <header>
		<h1>ex1</h1>
        </header>
        
        <main>
            <h2>GET submit</h2>
            <c:url var="ex2" value="/ex2" />
            <form action="${ ex2 }"> <%-- Form 메서드의 기본 방식은 GET --%>
                <input type="text" name="username" placeholder="이름 입력" />
                <input type="number" name="age" placeholder="나이 입력" />
                <input type="submit" value="제출" />
            </form>
            
            <h2>Post submit</h2>
            <c:url var="ex3" value="/ex3" />
            <form action="${ ex3 }" method="post"> <%-- Form 메서드의 기본 방식은 GET --%>
                <input type="text" name="username" placeholder="이름 입력" />
                <input type="number" name="age" placeholder="나이 입력" />
                <input type="submit" value="제출" />
            </form>
            
            <h2>DTO submit</h2>
            <c:url var="ex4" value="/ex4" />
            <form action="${ ex4 }" method="get"> <%-- Form 메서드의 기본 방식은 GET --%>
                <input type="text" name="username" placeholder="이름 입력" />
                <input type="number" name="age" placeholder="나이 입력" />
                <input type="submit" value="제출" />
            </form>
            
        </main>
	</body>
</html>