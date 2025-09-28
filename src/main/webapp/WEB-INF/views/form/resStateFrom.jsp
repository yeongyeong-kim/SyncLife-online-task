<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 테이블 -->

<c:if test="${empty login }">
	<h3>미팅 예약 사이트에 어서오세요.</h3>
	<p>로그인 하셔야 검색 가능합니다.</p>
	
</c:if>
<c:if test="${!empty login }">
	<form action="search" method="get">
		조회 날짜 &nbsp; <input type="date" name="date">&nbsp;
	<input type="submit" value ="검색">
</c:if>
