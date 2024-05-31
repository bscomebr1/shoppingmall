<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CSS Header Footer Design</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <header>
        <h1>마이페이지</h1>
        <nav>
            <ul>
                <li><a href="http://localhost:8099/">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="http://localhost:8099/signinform">signin</a></li>
                <li><a href="http://localhost:8099/loginform">Login</a></li>
            </ul>
        </nav>
    </header>
    <!-- 마이페이지 장바구니에 담은게 보여야할것이고 구매하는데 몇개를 구매한건지 -->
    <main>
    	<h3>장바구니에 담은것 
    	<table border=1>
	    	<thead>
	    		<tr>
	    			<th>품목명</th><th>품목설명</th><th>장바구니에 담은 수</th>
	    		</tr>
	    	</thead>
	    	<tbody>
		    	<c:forEach var="mylist" items="${my}">
		    		<tr>
		    			<td>${mylist.odsname }</td>
		    			<td>${mylist.content }</td>
		    			<td>${mylist.cartcount }</td>
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