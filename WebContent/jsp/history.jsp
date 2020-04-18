<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="shopping.HistoryBean" %>
<%@ page import="java.util.ArrayList"  %>
<<jsp:useBean id="user" scope="session" class="shopping.UserBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/MyShopping2/css/shopping.css" rel="stylesheet" type="text/css">
<title>My Shopping</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h1><jsp:getProperty property="name" name="user"/>さんの購入一覧</h1>
	<% ArrayList<HistoryBean> historyList = (ArrayList<HistoryBean>)request.getAttribute("history"); %>
	<table>
		<tbody>
			<tr>
				<th>商品ID</th>
				<th>商品名</th>
				<th>購入数</th>
			</tr>
			<% for(HistoryBean historybean : historyList) {%>
				<tr>
					<td><%= historybean.getItemId() %></td>
					<td><%= historybean.getItemName() %></td>
					<td><%= historybean.getQuantity() %></td>
				</tr>
			<% } %>
		</tbody>
		<form action="./shopping/ShoppingListServlet">
			<input type="sumbmit" value="商品一覧に戻る">
		</form>
	</table>
</body>
</html>