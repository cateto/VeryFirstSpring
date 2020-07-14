<%@ page language="java" contentType="text/html; charset=utf-8" 
import="java.util.*, java.sql.*, com.md.domain.Board"%>


<!DOCTYPE html>
<html>
<head>
<style>
	table, th, td {
	   border: 1px solid black;
	   border-collapse: collapse;
	}
	th, td {
	   padding: 5px; font-family:Comic Sans MS
	}
	a { text-decoration:none }
</style>
<meta charset="utf-8">
<title>My Board with Spring</title>
</head>
<body>
	<center>
	<font color=black size='4' face='Comic Sans MS'>
	<hr width='600' size='2' color='gray' noshade>
	<h3>MY Board with Spring</h3>
	<font color='gray' size='4' face='Comic Sans MS'>
	<a href='write.do'>글쓰기</a>
	</font>
	<hr width='600' size='2' color='gray' noshade>
	</font>

<% 
	Board bd = (Board)request.getAttribute("board");
%>
		<table border='2' width='600' align='center' noshade>
		<tr>
		<td width='20%' align='center' bgcolor='AliceBlue'>No</td>
		<td><%=bd.getSeq()%></td>
		</tr>
		<tr>
		<td width='20%' align='center' bgcolor='AliceBlue'>Writer</td>
		<td><%=bd.getWriter()%></td>
		</tr>
		<tr>
		<td align='center' bgcolor='AliceBlue'>E-mail</td>
		<td><%=bd.getEmail()%></td>
		</tr>
		<tr>
		<td align='center' bgcolor='AliceBlue'>Subject</td>
		<td><%=bd.getSubject()%></td>
		</tr>
		<tr>
		<td align='center' bgcolor='AliceBlue'>Contents</td>
		<td><%=bd.getContent()%></td>
		</tr>
		<td align='center' bgcolor='AliceBlue'>Date</td>
		<td><%=bd.getRdate()%></td>
		</table>

		<hr width='600' size='2' color='gray' noshade>
		<font color='gray' size='4' face='Comic Sans MS'>
		<a href='update.do?seq=<%=bd.getSeq()%>'>수정</a>
		&nbsp;&nbsp;|
		<a href='del.do?seq=<%=bd.getSeq()%>'>삭제</a>
		&nbsp;&nbsp;|
		<a href='list.do?cp=1&ps=3'>목록</a>
		</font>
		<hr width='600' size='2' color='gray' noshade>
		</center>
</body>	
</html>
<%
%>