<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>20230214 myweb home</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
<h1> 서버 프로그램 구현</h1>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	
	<c:if test="${not empty lgnss}">
		<button class="btn myinfo">내정보 보기</button>
	</c:if>	
	
	<jsp:include page="/WEB-INF/view/board/boardlist.jsp"></jsp:include>
	
	<script>
	$(".btn.login").on("click", handlerClickBtnLogin);
	$(".btn.logout").on("click", handlerClickBtnLogout);
	$(".btn.myinfo").on("click", handlerClickBtnMyinfo);
	
	function handlerClickBtnMyinfo(){ // 이건 get 으로 들어감
		console.log("로그인 눌림");		
		location.href="<%=request.getContextPath()%>"+"/myinfo";
	}
	function handlerClickBtnLogin(){
		console.log("로그인 눌림");		
		location.href="<%=request.getContextPath()%>"+"/login";
		//location.href="/WEB-INF/login.jsp";
	}
	function handlerClickBtnLogout(){
		console.log("로그아웃 눌림");
		location.href="<%=request.getContextPath()%>"+"/logout";
	}

	</script>
	
</body>
</html>