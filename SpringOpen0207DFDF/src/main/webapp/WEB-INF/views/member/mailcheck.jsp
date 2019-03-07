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
        text-align: center;
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
            <li><a href="../../../member/memberReg">회원가입</a></li>
            <li><a href="../../../member/login">로그인</a></li>
            <li><a href="../../../member/view">회원마이페이지(회원)</a></li>
            <li><a href="../../../member/list">회원리스트(회원)</a></li>
            <li><a href="../../../board/insert">글작성하기</a></li>
			<li><a href="../../../board/list">게시판</a></li>
            <li><a href="../../../emp/list">사원리스트</a></li>
            <li><a href="../../../emp/insert">사원등록</a></li>
        </ul>
        <hr>
    </nav>
    <article>
        <h2>메일인증 성공</h2>
        <hr>
        <h4>메일인증에 성공하였습니다.</h4>
        <a href="../../../">메인</a>
    </article>
	
</body>
</html>