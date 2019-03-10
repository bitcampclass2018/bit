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
	<h1>수정완료</h1>
	<a href="#" id="close">닫기</a>
</body>
<script>
	$('#close').on('click',function(){
		opener.parent.location.reload();
		 window.close();
	});
</script>
</html>