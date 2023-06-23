<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP문자열실습</title>
</head>
<body>
<h1>${aaa}</h1>
<!--  <h1>vo.x: ${sd.getX()},vo.y: ${ww.getX()}</h1>-->
<%-- <h1>vo.x: ${sd.x},vo.y: ${ww.y}</h1> --%>
<h1>vo.x: ${mv.x},vo.y: ${mv.y}</h1>
<h1>vo.x: ${myVo.x},vo.y: ${myVo.y}</h1>
</body>
</html>