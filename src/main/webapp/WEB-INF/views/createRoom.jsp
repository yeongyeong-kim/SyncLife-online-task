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
<h1>room 생성</h1>
<jsp:include page="common/menu.jsp" flush="true"></jsp:include><BR>
<hr>
<jsp:include page="form/createRoomForm.jsp" flush="true"></jsp:include>
</body>
</html>