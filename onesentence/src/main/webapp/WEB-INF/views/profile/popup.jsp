<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<!-- <form method="post" action="../update"> -->
	<form>
		유저번호(변경x) <input type="text" name="userIdx" id="userIdx" value="${user_info.userIdx}"><br>
		userName <input type="text" name="userName" id="userName" value="${user_info.userName}"><br>
		userPassword <input type="password" name="originalPassword" id="originalPassword" value="${user_info.userPassword}"><br>
		비밀번호수정 <input type="password" name = "newPassword" id="newPassword"><br>
		비밀번호확인 <input type="password" name = "checkNewPassword" id="checkNewPassword"><br>
		userIntroduction <input type="text" name="userIntroduction" id="userIntroduction" value="${user_info.userIntroduction}"><br>
		<button id="btn">수정완료</button>
	</form>
	<script>
		var btn = document.getElementById('btn');
		btn.onclick=function(){
			alert("이벤트성공");
			var newPassword = $('#newPassword').val();
			var checkNewPassword = $('#checkNewPassword').val();
			var userName = $('#userName').val();
			console.log(newPassword);
			console.log(checkNewPassword);
			console.log(checkNewPassword===newPassword);
			
			
			
			if(!(checkNewPassword!==newPassword||userName==null||userName==="")){
				var result = confirm("수정하시겠습니까?");
				if(result){
				$('form').prop('action','../update');
				}
			}else{
				alert("올바르지 않은 입력입니다.");
			}		
		}
	
		
		
		
	</script>
	
</body>
</html>