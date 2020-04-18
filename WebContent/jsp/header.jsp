<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="shopping.LoginUserBean"/>
<div align=right>
	ようこそ<jsp:getProperty property="name" name="user">さん
	<a href="/shopping/LoginServletShopping">購入履歴</a>
	<a href="/shopping/LoginServletShopping">ログアウト</a>
</div>