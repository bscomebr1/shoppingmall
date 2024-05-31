<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/singinlogin.css">
</head>
<body>
 <header>
        <h1>로그인</h1>
        <nav>
            <ul>
                <li><a href="http://localhost:8099/">Home</a></li>
                <li><a href="http://localhost:8099/signinform">signin</a></li>
                <li><a href="http://localhost:8099/loginform">Login</a></li>
            </ul>
        </nav>
    </header>
	<!-- 내용 -->
	<form action="login" method="post">
		<label for="username">Username:</label> 
		<input type="text" name="username"><br><br> 
		<label for="password">Password:</label>
		<input type="password" name="password"><br><br>
		<input type="submit" value="Login">
	</form>
<!-- 내용 끝 -->
<footer>
        <p>&copy; 2024 My Website. All rights reserved.</p>
    </footer>

</body>
</html>