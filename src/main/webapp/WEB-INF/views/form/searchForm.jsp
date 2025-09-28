<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
    var contextPath = '${pageContext.request.contextPath}'; // e.g., "/app"
    var searchDay = '<c:out value="${searchDay}" />';

    function delReservation(time){
        location.href = contextPath + "/deletRes?date=" 
                        + encodeURIComponent(searchDay) 
                        + "&time=" + encodeURIComponent(time);
    }

    function inReservation(time){
        location.href = contextPath + "/insertRers?date=" 
                        + encodeURIComponent(searchDay) 
                        + "&time=" + encodeURIComponent(time);
    }
</script>


<!-- 테이블 -->

<c:if test="${empty login }">
	<h3>미팅 예약 사이트에 어서오세요.</h3>
	<p>로그인 하셔야 검색 가능합니다.</p>
	
</c:if>
<c:if test="${!empty login }">
	<form action="search" method="get">
		조회 날짜 &nbsp; <input type="date" name="date">&nbsp;
	<input type="submit" value ="검색">
	</form>
	
	<table border="1"width="50%" cellspacing="2" cellpadding="5" >
			<tr>
				<td>시간(시:분)</td>
				<td>예약 룸</td>
				<td>예약 유무</td>
			<c:choose>
			    <c:when test="${login.role eq 'ADMIN'}">
			        <td>예약/취소</td>
			    </c:when>
			    <c:when test="${login.role eq 'OWNER'}">
			        <td>예약</td>
			    </c:when>
			</c:choose>
			</tr>
			<c:if test="${!empty resMap}">
			    <c:forEach var="i" items="${resMap}">
			        <tr>
			            <td>${i.key}</td>
			            <c:choose>
						    <c:when test="${login.role eq 'ADMIN'}">
						    	<c:if test="${i.value.situation}">
						    		<td>${i.value.roomName}</td>
						    		<td>${i.value.situation}</td>
						    		<td><input type="button" value="예약취소" onclick="delReservation('${i.key}')"></td>
						    	</c:if>
						    	<c:if test="${!i.value.situation}">
						    		<td></td>
						    		<td></td>
						    		<td><input type="button" value="예약" onclick="inReservation('${i.key}')"></td>
						    	</c:if>
						        
						    </c:when>
						    <c:when test="${login.role eq 'OWNER'}">
						       
						    	<c:if test="${!i.value.situation}">
						    		 <td><input type="button" value="예약" onclick="inReservation('${i.key}"></td>
						    	</c:if>
						    	<c:if test="${i.value.situation}">
						    		<td></td>
						    	</c:if>
						    
						    </c:when>
						</c:choose>
		                
			        </tr>
			    </c:forEach>
			</c:if>
	</table>
</c:if>
