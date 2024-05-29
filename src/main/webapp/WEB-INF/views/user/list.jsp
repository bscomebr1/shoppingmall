<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CSS Header Footer Design</title>
    <link rel="stylesheet" href="css/styles.css">
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
      <table border=1>
      <thead>
      	<tr>
      		<th>상품명</th><th>상품가격</th><th>상품설명</th><th>장바구니</th>
      	</tr>
      </thead>
      <tbody>
      	<c:forEach var="dto" items="${list }">
      	<tr>
      		<td>${dto.odsname }</td>
      		<td>${dto.odsprice }</td>
      		<td>${dto.content }</td>
      		<td><input type="button" value="장바구니" name=""></td>
      	</tr>
      </c:forEach>
      </tbody>
      
      
      </table>
      
    </main>
    
    <footer>
        <p>&copy; 2024 My Website. All rights reserved.</p>
    </footer>
</body>
</html>