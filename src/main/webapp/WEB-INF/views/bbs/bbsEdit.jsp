<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>		
<!DOCTYPE html>            
<html>                     
<head>                     
<meta charset=\"UTF-8\">   
<title>게시판</title>  
</head>                    
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
              	
<h1>게시글수정</h1>
<form action='${pageContext.request.contextPath}/bbs/edit.do' method='post'>
		<input type='hidden' name='bbsNo' value="${bbsVo.bbsNo}"/><br>
		제 목 : <input type='text' name='bbsTitle' value='<c:out value="${bbsVo.bbsTitle}" />'/><br>
		내 용 : <textarea rows="5" cols="30" name="bbsContent"><c:out value="${bbsVo.bbsContent}" /></textarea><br>
		작성자 : <c:out value="${bbsVo.bbsWriter}" /><br>
		등록일 : <fmt:formatDate value="${bbsVo.bbsRegDate}" pattern="yyyy/MM/dd HH:mm:ss"/><br>
		<input type='submit' value="저장"/>
		
</form>
<a href='${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsVo.bbsNo}'><button type='button'>삭제</button></a>
 		
<form action='${pageContext.request.contextPath}/member/del.do' method='get'>
		 <button> form 삭제</button>
		<%-- 아이디 : <c:out value="${mvo.memId}"/> --%>
		<input type="hidden" name='memId' value='<c:out value="${mvo.memId}" />'readonly="readonly"/><br>
	<!-- 	비밀번호 : <input type='password' name='memPass' value=''/><br> -->
		<%-- <input type='hidden' name='memName' value='<c:out value="${mvo.memName}" />'/><br>
		<input type='hidden' name='memPoint' value='${mvo.memPoint}'/><br> --%>
		
</form>



</body>
</html>
<!-- 1.	회원정보변경 화면에서 이름과 포인트를 변경하고 submit 버튼을 클릭하면,
	MemEditServlet 클래스의 doPost 메서드가 실행되도록 memEidt.jsp 파일을 변경하세요.
2.	회원정보변경 화면에서 아이디는 키보드로 값을 입력(변경)할 수 없도록
	memEdit.jsp 파일을 변경하세요.
3.	MemEidtServlet 클래스의 doPost메서드에서 사용자가 입력한 정보에 따라서
	데이터베이스의 회원 정보(이름, 포인트)가 변경되도록
	MemEditServlet.java, MemberDao.java, MemberDaoBatis.java, MemberMapper.xml 파일을 변경하세요.   -->