<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="item" scope="request" class="shopping.ItemBean"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/MyShopping2/css/shopping.css" rel="stylesheet" type="text/css">
<title>My Shopping</title>
</head>
	<body>
		<jsp:include page="header.jsp"/>
		<h1>購入確認</h1>
		<p>次の商品を購入しますか？</p>
		<form action="./ResultServlet" method="post">
			<table>
				<tbody>
					<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th>価格</th>
						<th>数量</th>
					</tr>
					<tr>
						<td><jsp:getProperty property="id" name="item"/></td>
						<td><jsp:getProperty property="name" name="item"/></td>
						<td><jsp:getProperty property="price" name="item"/></td>
						<td><jsp:getProperty property="quantity" name="item"/></td>
						<td>
							<input type="submit" value="購入">
							<input type="hidden" name="item_id" value="<%=item.getId() %>">
							<input type="hidden" name="item_quantity"  value="<%= request.getAttribute("quantity")%>">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>