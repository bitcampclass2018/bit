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
	<h1> Rest update</h1>
    	아이디 : <input type="text" id="id"><br>
    	비밀번호 : <input type="text" id="password"><br>
    	<input type="submit" value="변경" id="btn">
    	<input type="submit" value="해당아이디 삭제" id="btn2">
<script>
	$('#btn').on('click', function(){
		var arr = { id: $('#id').val(), password : $('#password').val()};
		$.ajax({
			url : '../rest/'+$('#id').val(),
			type:'PUT',
			data : JSON.stringify(arr),
			dataType: 'json',
			contentType : 'application/json; charset=utf-8',
			async : false,
			success : function(msg){
				alert(JSON.stringify(msg));
				console.log('put success');
			},error:function(){
				console.log('error!');
			}
		});
	});
	
	$('#btn2').on('click',function(){
		var arr = { id:$('#id').val()};
		$.ajax({
			url : '../rest/'+$('#id').val(),
			type:'DELETE',
			data : JSON.stringify(arr),
			dataType: 'json',
			contentType : 'application/json; charset=utf-8',
			async : false,
			success : function(msg){
				alert(JSON.stringify(msg));
				console.log('delete success');
			},error:function(){
				console.log('error!');
			}
		});
	});
</script>
</body>
</html>