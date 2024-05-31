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
    <style>
        
        table {
            width: 100%;
            border-collapse: collapse;
        }
        
        th, td {
            width: 25%;
            padding: 8px;
            text-align: center; 
            border: 1px solid #dddddd;
        }
        
        th {
            background-color: #f2f2f2;
            color: #333;
        }
    </style>
     
</head>
<body>
    <header>
        <h1>PhonepalAh</h1>
        <nav>
            <ul>
                <li><a href="http://localhost:8099/">Home</a></li>
                <li><a href="http://localhost:8099/admin/writeform">상품등록하기</a></li>
                <li><a href="http://localhost:8099/signinform">signin</a></li>
                <li><a href="http://localhost:8099/loginform">Login</a></li>
            </ul>
        </nav>
    </header>
    
    <main>
      <table>
        <thead>
          <tr>
            <th>상품명</th><th>상품가격</th><th>상품설명</th><th>이미지</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="dto" items="${list}">
            <tr>
              <td><a href="/user/detail?odsid=${dto.odsid}" value="${dto.odsid}">${dto.odsname}</a></td>
              <td>${dto.odsprice}</td>
              <td>${dto.content}</td>
              <td><img src="/images/user/${dto.goodsimg}"></td>
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
