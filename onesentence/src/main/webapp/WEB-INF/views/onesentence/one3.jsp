<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한문장 리스트</title>
	<meta property="og:url" content="http://127.0.0.1/sentence/onesentence/one/${onesentence.userIdx}" />
    <meta property="og:type" content="website" />
    <meta property="og:title" content="한문장" />
    <meta property="og:description" content="한문장내용" />
    <meta property="og:image" content="https://www.your-domain.com/path/image.jpg" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
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
					<td>${onesentence.userIdx}</td>
					<td>${onesentence.userName}</td>
					<td id="idx">${onesentence.oneSentenceIdx}</td>
					<td>${onesentence.oneSentence}</td>
					<td>${onesentence.page}</td>
					<td>${onesentence.oneSentenceRegisteredTime}</td>
					<td>${onesentence.isbn}</td>
					<td>${onesentence.bookTitle}</td>
					<td>${onesentence.author}</td>
					<td>${onesentence.publisher}</td>
					 <td><a href="#" id="updateBtn" onclick="updateClick(${list.oneSentenceIdx})">수정</a>
					 &nbsp;<a href="../../onesentence/delete/${list.oneSentenceIdx}" id="deleteBtn">삭제</a></td>
					 <%-- <td><div class="fb-share-button" 
    data-href="http://127.0.0.1/sentence/onesentence/one/${onesentence.userIdx}" 
    data-layout="button_count">
  </div></td> --%>
  <td>
  	<a href="#" id="test" onclick="up1()">버틑1</a>
  	<a href="#"  onclick="up2()">버틑2</a>
  </td>
  
	</tr>
	</c:forEach>
		</table>
		
		<a id="btn1" class="fb-share-button" href="http://127.0.0.1/sentence/onesentence/one/${list.oneSentenceIdx}" onclick="up()"
  >btn1</a>
		
		<button id="btn2" class="fb-share-button" 
    data-href="http://127.0.0.1/sentence/onesentence/one/${onesentence.userIdx}" 
    data-layout="button_count">btn2</button>

<script>
(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.0";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

function updateClick(idx){
	console.log("수정Click");
	var url="../../onesentence/popup/"+idx;
	var popupOption="width=700,height=600";
	window.open(url,"한문장수정하기",popupOption);	
}

function up(){
	alert("연결");
	$("meta[property=og:url]").attr("content", "http://127.0.0.1/sentence/onesentence/one/${onesentence.userIdx}");
}

function up1(){
	alert("버튼1")
	$("#btn1").trigger("click");


}
function up2(){
	alert("버튼2")
	$("#btn2").trigger("click");
	/* $('#btn2').onclick=true; */

}


/* function pop_close(){
    opener.location.reload();
    window.close();
} */


</script>		
		
		
</body>
</html>