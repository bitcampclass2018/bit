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
	
	<form method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="uid"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="upw"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="uname"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="uemail"></td>
		</tr>
		<tr>
			<td>사진</td>
			<td><input type="file" name="uphoto"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="회원가입"></td>
		</tr>
	</table>
	</form>
	 </article>
</body>
</html>