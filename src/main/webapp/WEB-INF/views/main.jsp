<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${!empty msg}">
    <script type="text/javascript">
        alert("${msg}");
    </script>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Meeting room reservations</title>
</head>
<body>
<h1>메인화면입니다.</h1>
<jsp:include page="common/menu.jsp" flush="true"></jsp:include><BR>
<hr>
<jsp:include page="form/searchForm.jsp" flush="true"></jsp:include>

</body>
</html>