<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		
<!DOCTYPE html>            
<html>                     
<head>                     
<meta charset=\"UTF-8\">   
<title>게시판</title>  
</head>                    
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>           	

<h1>새 글쓰기</h1>
<form action='${pageContext.request.contextPath}/bbs/add.do' method='post'>
		제 목 : <input type='text' name='bbsTitle' value=''/><br>
		내 용 : <textarea name='bbsContent' rows="5" cols="30"></textarea><br>
		<input type='submit'/>
</form>
</body> 
</html>  