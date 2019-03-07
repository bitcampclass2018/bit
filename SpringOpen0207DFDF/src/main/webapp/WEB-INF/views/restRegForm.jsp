<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        nav li{
            display: inline-block;
            padding-left: 20px;
        }
        nav a{
            text-decoration: none;
            color:black;
        }
        article * {
        padding: 10px;
        text-align: center;
        margin: 0 auto;
        }
        article>ul{
            margin-left: 250px;
            width: 300px;
            height: 400px;
        }
        article li{
            margin-top: 20px;
            list-style: none;
        }
        article input,div{
            float: right;
        }
        #result{
            margin-right: 150px;
        }
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<header>
        <h1>Open Project</h1>
        <hr>
    </header>
    <nav>
        <ul>
            <li><a href="../member/memberReg">회원가입</a></li>
            <li><a href="../member/logout">로그아웃</a></li>
            <li><a href="../member/view">회원마이페이지(회원)</a></li>
            <li><a href="../member/list">회원리스트(회원)</a></li>
            <li><a href="../board/insert">글작성하기</a></li>
			<li><a href="../board/list">게시판</a></li>
            <li><a href="../emp/list">사원리스트</a></li>
            <li><a href="../emp/insert">사원등록</a></li>
        </ul>
        <hr>
    </nav>

<article>
	<h2>회원가입</h2>
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="uid" id="uid"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="upw" id="upw"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="uname" id="uname"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="uemail" id="uemail"></td>
		</tr>
		<!-- <tr>
			<td>사진</td>
			<td><input type="file" name="uphoto"></td>
		</tr> -->
		<tr>
			<td colspan="2"><input type="submit" value="회원가입" id="btn"></td>
		</tr>
	</table>
	 </article>
	 <script>
	 	$('#btn').click(function(){
	 		var arr = {id : $('#uid').val(), password : $('#upw').val(), name : $('#uname').val(), email: $('#uemail').val()};
	 		console.log(arr);
	 		$.ajax({
	 			url: '../rest/regMember',
	 			type: 'POST',
	 			data: JSON.stringify(arr),
	 			dataType : 'json',
	 			contentType : 'application/json; charset=utf-8',
	 			async : false,
	 			success : function(msg){
	 				alert(JSON.stringify(arr));
	 			}
	 		});
	 	});
	 </script>
</body>
</html>