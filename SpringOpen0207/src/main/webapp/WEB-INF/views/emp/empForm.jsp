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
	<h2>사원등록하기</h2>
	<form method="post">
	<table>
		<tr>
			<td>사원번호</td>
			<td><input type="text" name="empno"></td>
		</tr>
		<tr>
			<td>사원이름</td>
			<td><input type="text" name="empname"></td>
		</tr>
		<tr>
			<td>부서</td>
			<td><input type="text" name="deptno"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="사원등록"></td>
		</tr>
	</table>
	</form>
	</article>
</body>
</html>