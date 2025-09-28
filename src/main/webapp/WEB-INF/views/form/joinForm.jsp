<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#userid").on("keyup",function(){
			$.ajax({
				url:"idCheck",
				type:"post",
				data:{
					id:$("#userid").val()
				},
				dataType:"text",
				success:function(data,status,xhr){
					$("#result").text(data);
				},
				error:function(xhr,status,error){}
			}); //end ajax
		}); //end userid keyup
		
		$("#passwd2").on("keyup",function(){
			var pass1 = $("#passwd1").val();
			var pass2 = $("#passwd2").val();
			if(pass1 == pass2){
				$("#result2").text("비밀번호 일치");
			}else{
				$("#result2").text("비밀번호 불일치");
			}
		}); //end passwd2 keyup

		
	}); //end read
		

</script>

<form action = "join" method="post">
	아이디:&nbsp;<input type="text" name = "userid" id="userid">&nbsp;<span id="result"></span><br>
	비밀번호:&nbsp;<input type="text" name = "password" id="passwd1"><br>
	비밀번호 확인:&nbsp;<input type="text" name="password2" id="passwd2">&nbsp;<span id="result2"></span><br>
	이름:&nbsp;<input type="text" name = "memName">
	<input type="hidden" name = "role" value="OWNER" readonly>&nbsp;
	<hr>
	<input type="submit" value="회원가입">&ensp;
	<input type="reset" value="취소">
</form>

	