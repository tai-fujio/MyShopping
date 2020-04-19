<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="shopping.UserBean"/>
<div align=right>
	ようこそ<jsp:getProperty property="name" name="user"/>さん
	<a href="../../MyShopping/BoughtListServlet">購入一覧</a>
	<a href="../../MyShopping/LoginServlet?submit=logout">ログアウト</a>
</div>