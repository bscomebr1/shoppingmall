<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
        <h1>detail</h1>
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
      		<th>상품명</th><th>상품가격</th><th>상품설명</th><th>갯수</th><th>장바구니</th>
      	</tr>
      </thead>
      <tbody>
      	
      	<tr>
      		<td>${detaillist.odsname }</td>
      		<td>${detaillist.odsprice }</td>
      		<td>${detaillist.content }</td>
            <form action="" method="post">
            
            <td><input type="text" name="cartcount" size="5"></td>
      		<td><input type="submit" value="장바구니"></td>
            </form> 
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