<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		 $('#roomSelect').on('change', function() {
		        var selectedRoom = $(this).val(); // 선택된 option 값
		        $('#roomInput').val(selectedRoom); // input에 값 넣기
		    });
	}); //end read
		

</script>

<form action="${pageContext.request.contextPath}/reservaion" method="post">
    예약 시간:&nbsp;
    <input type="text" name="start" id="start" value="${data.start}" readonly>&nbsp;-&nbsp;
    <input type="text" name="end" id="end" value="${data.end}" readonly><br><br>

    방 이름 : <input type="text" id="roomInput" placeholder="방 이름 입력" readonly>&nbsp;
    <select name="roomName" id="roomSelect">
        <c:forEach var="room" items="${data.roomList}">
       
            <option id = "roomname" value="${room}">${room}</option>
        </c:forEach>
    </select>

    <hr>
    <input type="submit" value="생성">
    <input type="reset" value="취소">
</form>
	