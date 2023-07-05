<%-- <%@page import="com.exam.member.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.member.MemberDaoBatis"%>
<%@page import="com.exam.member.MemberDao"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%-- DBMS에서 데이터를 가져온다. but DBMS가 아닌 memListServlet에서 폴더를 직접 지정했기 때문에 필요없으므로 삭제처리 ->  import 삭제 (==)
	<%!
	private MemberDao memberDao = new MemberDaoBatis();
	%>
	<%
	List<MemberVo> list = memberDao.selectMemberList();
	request.setAttribute("memberList", list);
	%>
	 --%>
	<!DOCTYPE html>             
	<html>                       
	<head>                      
	<meta charset=\"UTF-8\">    
	<title>게시판</title>  	
	</head>                 
	<body>
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	
	<h2>게시글목록</h2>
	<a href='${pageContext.request.contextPath}/bbs/add.do'>글쓰기</a>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일시</th>
			</tr>	
		</thead>
			
		<tbody>
				<c:forEach var="vo" items='${bbsList}'>	
					<tr>	
						<td>${vo.bbsNo}</td>
						<td>
						<a href="${pageContext.request.contextPath}/bbs/edit.do?bbsNo=${vo.bbsNo}">
						<c:out value="${vo.bbsTitle}"/>
						</a>
						</td>
						<td><c:out value="${vo.bbsWriter}"/></td>
						
						<td><fmt:formatDate value="${vo.bbsRegDate}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
						<!--등록일시가 2023/06/29 14:00:12 형식으로 출력되도록 변경  -->
					</tr>
				</c:forEach>	
		</tbody>
	</table>
	
</body>
</html>


