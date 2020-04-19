<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean scope="session" id="user" class="shopping.UserBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/MyShopping2/css/shopping.css" rel="stylesheet" type="text/css">
<title>My Shopping</title>
</head>
<body>
	<div>
		<h1>ようこそ My Shopping へ</h1>
		<p>IDとパスワードを入力してください</p>
		<form action ="../LoginServlet" method="post">
			<table>
				<tbody>
					<tr>
						<th>ユーザー名:</th>
						<td><input type="text" name="name" value="<%=user.getName() %>"/></td>
						<th>パスワード:</th>
						<td><input type="password" name="password"/></td>
					</tr>
				</tbody>
			</table>
				<input type="submit" name="submit" value="ログイン" />
				<% if (("true").equals(session.getAttribute("isLogged"))) { %>
					<input type ="submit" name="submit" value="" />
				<% }%>
		</form>
	</div>
</body>
</html>