<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ErrorLogin</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
<script>
	var errorMsg= '<%=(String)request.getAttribute("errorMsg")%>';
	//var errMsg= '${errorMsg }';
	alert(errorMsg)
</script>
	<h4>로그인 되지 않았습니다. 정보가 없습니다. 로그인 페이지로 이동합니다</h4>
	<a href="<%=request.getContextPath()%>"+"/login">로그인 페이지로 이동합니다</a>
	

</body>
</html>