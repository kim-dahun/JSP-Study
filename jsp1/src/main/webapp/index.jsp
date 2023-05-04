<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <h1>Index</h1>
        
        <ul>
            <li>
                <a href='ex1'>First Servlet</a>
            </li>
            <li>
                <a href='ex2'>Second Servlet</a>
            </li>
            <li>
                <a href='ex3'>Third Servlet</a>
            </li>
            <li>
                <a href ='ex4'>ReDirect</a>
            </li>
            <li>
                <!-- URL 상대경로 : http://localhost:8081/contextRoot/
                까지를 현재 작업 디렉토리로 하고, 그 이후 주소만 표기하는 방식 -->
                <a href = 'intro.jsp'>Introduce JSP</a>
            </li>
            <li>
                <a href = 'form.jsp'>form submit</a>
            </li>
            <li>
                <a href = 'main.jsp'>include 지시문(directive)</a>
            </li>
            
            <li>
                <a href = "scriptlet.jsp">스크립트릿(scriptlet)</a>
            </li>
            
            <li>
                <a href = "actiontag.jsp">액션 태그(Action Tag)</a>
            </li>
            
            <li>
                <a href = "el.jsp">EL(Expression Language)</a>
            </li>
            <li>
                <a href ="jstl.jsp">JSTL</a>
            </li>
        </ul>
    </body>
</html>