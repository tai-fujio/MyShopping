<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/MyShopping2/css/shopping.css" rel="stylesheet" type="text/css">

<title></title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<% ArrayList<ItemBean> itemList = (ArrayList<ItemBean>) request.getAttribute("itemList");%>
	<form action="./BuyItemServlet">
		<table>
			<tr>
				<th>商品ID</th>
				<th>商品名</th>
				<th>価格</th>
				<th>在庫数</th>
				<th>数量</th>
			</tr>
			<% for(ItemBean bean : itemList) {%>
			<tr>
				<td><%= bean.getId() %></td>
				<td><%= bean.getName() %></td>
				<td><%= bean.getPrice() %></td>
				<td><%= bean.getStock() %></td>
				<td><%= bean.getQuantity() %></td>
				<td>
					<select name="<%= bean.getId() %>list">
						<%for(int i=0; i<=bean.getQuantity();i++) {%>
							<option value="<%=i %>"><%=i %></option>
						<% } %>
					</select>
				</td>
				<td>
					<input type="submit" value="購入" name="<%=bean.getId()%>submit">
				</td>
			</tr>
			<%} %>
		</table>
	</form>

</body>
</html>