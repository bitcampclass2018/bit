<%@page import="search_0123.BlogParser"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="search_0123.parse"%>
<%@page import="java.util.List"%>
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
        
    }
    h3{
        color:darkolivegreen;
        margin-left: 20px;
        font-size: 20px;
    }
    p{
        font-size: 15px;
        margin-left: 10px;
    }
    a{
        color: darkslategrey;
        text-decoration: none;
        font-size: 12px;
        float: right;
        margin-right: 10px;
    }

</style>
</head>
<body>
<div id="wrap">
	<h1>blog</h1>
	<%
		request.setCharacterEncoding("utf-8");
		String keyword = request.getParameter("keyword");
		BlogParser blog = new BlogParser();
		List<parse> plist = blog.pList(keyword);
		for (parse p : plist) {
	%>
	<h3><%=p.getTitle()%></h3><br>
	<p><%=p.getDescription()%></p><br>
	<a href=<%=p.getLink()%>><%=p.getLink()%></a><br>
	<hr>
	<%
		}
	%>

 </div>
</body>
</html>