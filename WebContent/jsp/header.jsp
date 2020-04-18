<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="shopping.UserBean"/>
<div align=right>
	ようこそ<jsp:getProperty property="name" name="user">さん
	<a href="/shopping/BoughtListServlet">購入</a>
	<a href="/shopping/LoginServlet">ログアウト</a>
</div>