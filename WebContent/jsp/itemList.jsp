<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="shopping.ItemBean" %>
<jsp:useBean scope="request" class="shopping.ItemBean" id="item"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/MyShopping2/css/shopping.css" rel="stylesheet" type="text/css">

<title>My Shopping</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<% ArrayList<ItemBean> itembeans = (ArrayList<ItemBean>)request.getAttribute("itemList");%>
	<form action="./ConfirmServlet">
		<table>
			<tr>
				<th>商品ID</th>
				<th>商品名</th>
				<th>価格</th>
				<th>在庫数</th>
				<th>数量</th>
				<th></th>
			</tr>
			<% for(ItemBean itembean : itembeans) {%>
			<tr>
				<td><%= itembean.getId() %></td>
				<td><%= itembean.getName() %></td>
				<td><%= itembean.getPrice() %></td>
				<td><%= itembean.getQuantity() %></td>
				<td>
					<select name="<%= itembean.getId() %>list">
						<%for(int i = 0; i <= itembean.getQuantity(); i++) {%>
							<option value="<%=i %>"><%=i %></option>
						<% } %>
					</select>
				</td>
				<% if (itembean.getQuantity() != 0) { %>
				<td>
					<input type="submit" value="購入" name="<%=itembean.getId()%>submit">
				</td>
				<% }else{ %>
				<td>売り切れ</td>
				<% } %>
			</tr>
			<% } %>
		</table>
	</form>

</body>
</html>