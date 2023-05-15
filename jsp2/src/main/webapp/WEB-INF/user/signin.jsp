<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Post</title>
	</head>
	<body>
		<header>
            <h1>로그인</h1>
        </header>
        
        <main>
            <form method="post">
                <div>
                    <input type="text" name="username" required autofocus placeholder="사용자 id 입력"/>
                    <input type="password" name="password" required placeholder="사용자 비밀번호 입력" />
                    <input type="submit" value="로그인"/>
                </div>
            
            </form>
        </main>
	</body>
</html>