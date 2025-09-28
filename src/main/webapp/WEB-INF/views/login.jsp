<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Meeting room reservations</title>
</head>
<body>
	<h1>로그인 화면</h1>
	
	<jsp:include page="common/menu.jsp" flush="true"></jsp:include><br>
	<hr>
	<jsp:include page="form/loginForm.jsp"></jsp:include>
</body>
</html>