<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
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
            <li><a href="member/memberReg">회원가입</a></li>
            <li><a href="member/login">로그인</a></li>
            <li><a href="member/view">회원마이페이지(회원)</a></li>
            <li><a href="member/list">회원리스트(회원)</a></li>
            <li><a href="board/insert">글작성하기</a></li>
			<li><a href="board/list">게시판</a></li>
            <li><a href="emp/list">사원리스트</a></li>
            <li><a href="emp/insert">사원등록</a></li>
        </ul>
        <hr>
        <ul>
        	<li><label>REST 과제</label></li>
        	<li><a href="rest/list">rest/list</a></li>
            <li><a href="rest/test">rest/test(id)</a></li>
			<li><a href="rest/regForm">rest/regForm</a></li>
			<li><a href="rest/updateForm">rest/updateForm</a></li>
        </ul>
    </nav>
    <article>
        <h2>메인화면</h2>
    </article>
</body>
</html>
