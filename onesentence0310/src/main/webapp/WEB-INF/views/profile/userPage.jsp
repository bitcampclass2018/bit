<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userPage</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	userIdx: ${profile.userIdx} <br>
	userName: ${profile.userName} <br>
	userPoint: ${profile.userPoint} <br>
	userIntroduction: ${profile.userIntroduction} <br>
	<a href="#" id="updateBtn" onclick="updateClick(${profile.userIdx})">프로필수정</a>
	<script>
	function updateClick(idx){
		console.log("수정Click");
		var url="../profile/popup/"+idx;
		var popupOption="width=700,height=600";
		window.open(url,"user update",popupOption);	
	}
	</script>

</body>
</html>