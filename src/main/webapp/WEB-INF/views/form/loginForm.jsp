<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${!empty mesg }">
	<script>
		alert('${mesg}');
	</script>
</c:if>
<form action = "login" method="post">
	아이디:<input type="text" name = "userid"><br>
	비밀번호:<input type="password" name = "password"><br>
	<input type="submit" value="로그인">
</form>