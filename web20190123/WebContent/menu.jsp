<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    *{
        margin: 0 auto;
    }
    #wrap{
        background-color: whitesmoke;
        width: 800px;
    }
    h1{
        color: darkslategrey;
        text-align: center;
        font-size: 25px;
    }
    form{
        padding: 30px;
        text-align: center;
    }
    #submit{
        background-color:darkslategrey;
        color:white;
        border: 0px;
    }

</style>
</head>
<body>
	<!-- <form action="/web20190123/bServlet" method="post"> -->
	<div id="wrap">
	<h1>검색어를 입력하세요.</h1>
	<form action="find.jsp" method="post">
		<input type="text" id="keyword" name="keyword">
		<input type="submit" value="찾기" id="submit">
	</form>
	</div>
</body>
</html>