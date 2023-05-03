<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP</title>
	</head>
	<body>
        <!-- 요청 방식(Method)
            1. GET
                => Default 값. 클라이언트에서 서버로 보내는 정보가 질의문자열(Query String) 에 포함되는 방식
                
            2. POST
                => Client 에서 Server로 보내는 정보가 HTTP 패킷에 포함되는 방식
            (참고) URL 형식
            - 프로토콜://서버주소:포트번호/(Context root 포함)경로/파일이름?질의문자열
            - http://localhost(or 192.168.20.3):8081/jsp1/form-result.jsp?id=???
         -->
		<form action = "form-result.jsp" method="post">
            <input type="text" name = "id" placeholder="이름 입력" 
               required autofocus />
            <input type="submit" value="전송" />
        </form>
	</body>
</html>