<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한문장 리스트</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<table border="1">
			<tr>
				<td>한문장번호</td>
				<td>한문장</td>
				<td>페이지</td>
				<td>작성시간</td>
				<td>작성자번호</td>
				<td>책번호</td>
				<td>수정,삭제</td>
			</tr>
			<c:forEach items="${oneSentenceList}" var="list">
				<tr>
					<td id="idx">${list.oneSentenceIdx}</td>
					<td>${list.oneSentence}</td>
					<td>${list.page}</td>
					<td>${list.oneSentenceRegisteredTime}</td>
					<td>${list.userIdx}</td>
					<td>${list.isbn}</td>
					<!-- <td><input type="submit" value="수정" id="updateBtn">&nbsp;<input type="submit" value="삭제" id="deleteBtn"></td> -->
					 <td><a href="#" id="updateBtn" onclick="updateClick(${list.oneSentenceIdx})">수정</a>
					 &nbsp;<a href="../../onesentence/delete/${list.oneSentenceIdx}" id="deleteBtn">삭제</a></td>
				</tr>
			</c:forEach>
		</table>

<script>
function updateClick(idx){
	console.log("수정Click");
	var url="../../onesentence/popup/"+idx;
	var popupOption="width=700,height=600";
	window.open(url,"한문장수정하기",popupOption);	
}

/* function pop_close(){
    opener.location.reload();
    window.close();
} */


</script>		
		
		
</body>
</html>