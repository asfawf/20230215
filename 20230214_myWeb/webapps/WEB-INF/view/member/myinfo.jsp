<%@ page import="kh.member.model.vo.MemberVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<button class="btn myhome">홈으로</button>

<script>
$(".btn.myhome").on("click", handlerClickBtnhome);

function handlerClickBtnhome(){ // 이건 get 으로 들어감
	console.log("로그인 눌림");		
	location.href="<%=request.getContextPath()%>"+"/";
}
</script>

<hr>
내 정보
<hr>
<c:if test="${empty myinfo }">
	<h4>로그인 되지 않았습니다. 정보가 없습니다.</h4>
	<a href="<%=request.getContextPath()%>"+"/"></a>
</c:if>
<c:if test="${not empty myinfo}">
	<h1>EL Request</h1>
		<div>
			<br>
			id: ${myinfo.id }
			<br>
			name: ${myinfo.name }
			<br>
			email: ${myinfo.email }
		</div>
</c:if>
<h4>EL Session</h4>
<br>
			id: ${lgnss.id }
			<br>
			name: ${lgnss.name }
			<br>
			email: ${lgnss.email }
<br>
<br>
<%	
	MemberVo ss= (MemberVo)session.getAttribute("lgnss");
%>
	<br>
	이건 ss: <%=ss.getId()%>
	<br>
<%
	MemberVo vo = null;
	Object obj = request.getAttribute("myinfo");
	if(obj == null){
		vo = (MemberVo)request.getAttribute("myinfo");
%>
			<h4>로그인되지 않았습니다 정보 X</h4>
			<a href=<%=request.getContextPath() %>/login">페이지 이동</a>
<%
	}else{
		if(obj instanceof MemberVo){
			vo= (MemberVo)obj;
		}	
		if(vo == null){
%>
		<h4>로그인되지 않았습니다 정보 X</h4>
			<a href=<%=request.getContextPath() %>/login">페이지 이동</a>
<%		
		}else{
%>			
			id: <%=vo.getId() %>
			<br>
			name: <%=vo.getName() %>
			<br>
			email: <%=vo.getEmail() %>
<%						
		}
	}
%>

</body>
</html>