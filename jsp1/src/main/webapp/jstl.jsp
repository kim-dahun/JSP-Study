<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP</title>
	</head>
	<body>
        <h1>JSTL</h1>
		<h2>JSTL Standard Tag Library</h2>
        
        <%-- JSTL 사용하기:
            1. POM.xml 파일에 의존성(dependency) 추가(jstl:jstl:1.2)
            2. JSTL 을 사용하는 JSP 파일에서 taglib 지시문을 설정.
         --%>
        
        <%
        // javax.servlet.jsp.jstl


        
        // HTML li 으로 사용할 더미 데이터를 생성:
            String[] sites = {"YouTube","Instagram","Facebook"};
        // -> Scriptlet 에서 선언한 지역 변수는 EL에서 사용 불가
        // -> EL에서 사용할 수 있는 변수는 pageContext, request, session, application 에 저장된 속성들.
        
        pageContext.setAttribute("sites", sites);
        
        
        %>
        
        <h2>JSP Scriptlet, expression</h2>
        
        <ul>
        <% for(int i = 0 ; i<sites.length ; i++){ %>
        
            <li><%=sites[i] %></li>
        
        <% } %>
        </ul>
        
        
        <h2>JSTL, EL</h2>
        <ul>
        
        <c:forEach  items="${ sites }" var="s">
            <li>${s}</li>
        </c:forEach>
        
        </ul>
        
	</body>
</html>