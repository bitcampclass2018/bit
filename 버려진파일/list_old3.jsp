<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한문장 리스트</title>
<link rel="image_src" href="http://www.wednesdayjournal.net/PEG/14381603616806.jpg" />
<meta property="og:type" content="website" /> 
<meta property="og:title" content="한문장" /> 
<meta property="og:description" content="한문장 내용" /> 
<meta property="og:image" content="http://14381603616806.jpg" /> 
<meta property="og:image:width" content="600"/>
<meta property="og:image:width" content="600"/>
<meta property="fb:app_id" content="302606807116615" /> 
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- <script>
$().ready(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.0&appId=302606807116615";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));
</script>ff-->
<style>
    a{
        text-decoration: none;
         
        
    }
    input{
        border-style: none;
    }
    li{
        list-style: none;
    }
    </style>
</head>
<body>
	<table border="1">
			<tr>
				<td>작성자번호</td> 
				<td>작성자이름</td>
				<td>한문장번호</td>
				<td>한문장</td>
				<td>페이지</td>
				<td>작성시간</td>
				<td>isbn</td>
				<td>책제목</td>
				<td>저자</td>
				<td>출판사</td>
				<td>수정,삭제</td>
				<td>공유</td>
			</tr>
			<c:forEach items="${oneSentenceList}" var="onesentence">
				<tr>
					<td class="idx">${onesentence.userIdx}</td>
					<td>${onesentence.userName}</td>
					<td>${onesentence.oneSentenceIdx}</td>
					<td>${onesentence.oneSentence}</td>
					<td>${onesentence.page}</td>
					<td>${onesentence.oneSentenceRegisteredTime}</td>
					<td>${onesentence.isbn}</td>
					<td>${onesentence.bookTitle}</td>
					<td>${onesentence.author}</td>
					<td>${onesentence.publisher}</td>
					 <td><a href="#" id="updateBtn" onclick="updateClick(${onesentence.oneSentenceIdx})">수정</a>
					 &nbsp;<a href="../../onesentence/delete/${onesentence.oneSentenceIdx}" id="deleteBtn">삭제</a></td>
  <td>
  	<a href="#" onclick="up(${onesentence.oneSentenceIdx})" id="test" >공유</a>
  </td>
  
	</tr>
	</c:forEach>
		</table>

<script>

function up(idx){
	alert(idx);
	var url = 'http://127.0.0.1/sentence/onesentence/one/'+idx;
	$('head').append('<meta property="og:url" content="'+url+'" />');
	
	var linkUrl = 'http://www.facebook.com/sharer.php?u=' + url;
	var popupOption="width=600,height=400";
	window.open(linkUrl,"페북공유",popupOption);

};

function updateClick(idx){
	console.log("수정Click");
	var url="../../onesentence/popup/"+idx;
	var popupOption="width=700,height=600";
	window.open(url,"한문장수정하기",popupOption);	
}



</script>		
		
		
</body>
</html>