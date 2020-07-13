<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Controller with Spring5 Index</title> <!--  쓰는 이유 : 웹 상에서 페이지 노출 -->
	</head>
<body>
	<h1>
		Controller with Spring5
	</h1>
	
	<a href="sample/">m01</a>(기본) &nbsp;&nbsp;
    <a href="sample/base1">m02</a>(All Method) &nbsp;&nbsp;
    <a href="sample/base2">m03</a>(Get&Post) &nbsp;&nbsp;
    <a href="sample/base3">m04</a>(Get) &nbsp;&nbsp;
    <a href="sample/form">form</a>(4Post) &nbsp;&nbsp;
    <br/>
	<a href="sample/param1?name=홍길동&age=22">m05</a>&nbsp;&nbsp;
    <a href="sample/param2?name=이순신&age=40">m06</a>&nbsp;&nbsp;
    <a href="sample/param3?names=강감찬&names=을지문덕&names=세종대왕">m07</a>&nbsp;&nbsp;
    <a href="sample/param4?names=이승철&names=한예슬&names=변진섭">m08</a>&nbsp;&nbsp;
    <a href="sample/param5?names=김유민&names=손영준&names=장건우">m09</a>&nbsp;&nbsp;	

    <!--  
    <a href="sample/param6?list[0].name=이순신&list[0].age=40&list[1].name=강감찬&list[1].age=50">m10</a>&nbsp;&nbsp;
    [ -> %5B
    ] -> %5D
    -->
	<a href="sample/param6?list%5B0%5D.name=이순신&list%5B0%5D.age=40&list%5B1%5D.name=강감찬&list%5B1%5D.age=50">m10</a>&nbsp;&nbsp;	
    <a href="sample/param7?name=홍길동&age=22&page=10">m11</a>&nbsp;&nbsp;
	<a href="sample/param8?subject=오늘&cdate=2020/07/13">m12</a>&nbsp;&nbsp;
	
	 <a href="sample/json1">m13</a>&nbsp;&nbsp;
	 <a href="sample/json2">m14</a>&nbsp;&nbsp;
	    <br/> 
	    
	 <a href="sample/file_list">file_list</a>&nbsp;&nbsp;
</body>
</html>