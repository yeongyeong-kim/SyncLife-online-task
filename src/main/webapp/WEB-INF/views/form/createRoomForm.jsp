<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#roomName").on("keyup",function(){
			$.ajax({
				url:"roomCheck",
				type:"post",
				data:{
					id:$("#roomName").val()
				},
				dataType:"text",
				success:function(data,status,xhr){
					$("#result").text(data);
				},
				error:function(xhr,status,error){}
			}); //end ajax
		}); //end roomName keyup

		
	}); //end read
		

</script>

<form action = "${pageContext.request.contextPath}/insertRoom" method="post">
	방 이름:&nbsp;<input type="text" name = "roomName" id="roomName">&nbsp;<span id="result"></span><br>
	수용 인원:&nbsp;<input type="text" name = "capacity" id="capacity"><br>
	지역:&nbsp;<input type="text" name="location" id="location">
	<hr>
	<input type="submit" value="생성">&ensp;
	<input type="reset" value="취소">
</form>

	