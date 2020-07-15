<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Model with Spring5 Index</title> <!--  쓰는 이유 : 웹 상에서 페이지 노출 -->
	</head>
<body style = "text-align:center">
	<h1>
		Model with Spring5
	</h1>
	
	<a href="address/list.do">주소록</a>(Spring5)<br/><br/>
	<a href="address1/list.do">주소록</a>(Spring5+MyBatis)<br/><br/>
	<a href="address2/list.do">주소록</a>(Spring5+MyBatis+이름정렬)<br/><br/>
	<a href="board/list.do?cp=1&ps=3">게시판(Spring5)</a><br/><br/>
	<a href="board1/list.do?cp=1&ps=3">게시판(Spring5+MyBatis)</a><br/><br/>
	<br/><br/><br/>
    
</body>
</html>