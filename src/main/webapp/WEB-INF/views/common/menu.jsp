<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${empty login }">
	<a href="login">로그인</a>&nbsp;
	<a href="join">회원가입</a>&nbsp;
	
</c:if>
<c:if test="${!empty login }">
안녕하세요? ${login.memName} 님 !<br>
	<c:if test="${login.role eq 'OWNER'}">
		<a href="logout">로그아웃</a>&nbsp;<!--  -->
	</c:if>
	<c:if test="${login.role eq 'ADMIN'}">
		<a href="logout">로그아웃</a>&nbsp;<!--  -->
		<a href="createroom">room 생성</a>
	</c:if>
</c:if>