<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/MyShopping2/css/shopping.css" rel="stylesheet" type="text/css">
<title>My Shopping</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h1>購入結果</h1>
	<p>ご購入ありがとうございます</p>
	<img src="/MyShopping/image/thank_you.jpg" width="100" height="100"/>
	<form action="ShoppingServlet" method="post">
		<input type="submit" value="戻る">
	</form>
</body>
</html>