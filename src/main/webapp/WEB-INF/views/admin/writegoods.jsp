<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CSS Header Footer Design</title>
<link rel="stylesheet" href="../css/styles.css">


</head>
<body>
	<header>
		<h1>Shoppingmall</h1>
		<nav>
			<ul>
				<li><a href="http://localhost:8099/">Home</a></li>
				<li><a href="#">About</a></li>
				<li><a href="http://localhost:8099/signinform">signin</a></li>
				<li><a href="http://localhost:8099/loginform">Login</a></li>
			</ul>
		</nav>
	</header>

	<main>

		<form action="writegoods" method="post" enctype="multipart/form-data">
			<label for="odsname">상품명:</label><br>
			<input type="text" name="odsname"><br>
			<label for="odsprice">상품가격:</label><br>
			<input type="text" name="odsprice"><br>
			<label for="content">상품설명:</label><br>
			<input type="text" name="content"><br>
			<label for="goodsimg">상품 이미지</label>
			<input type="file" name="goodsimg" multiple><br>
			<input type="submit" value="등록하기">
		</form>
	</main>

	<footer>
		<p>&copy; 2024 My Website. All rights reserved.</p>
	</footer>
</body>
</html>