<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<title>kh회원가입</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp"/>
<section>
<h1>회원가입</h1>
	<form action="enroll" method="post">
			id:<input type="text" name="id"> 
			<button type="button" id="dupId">중복id확인</button>
			<span></span>
			<br>
			pw:<input type="password" name="passwd">
			<br>
			name:<input type="text" name="name"> 
			<br>
			email:<input type="text" name="email"> 
			<br>
			<button type="submit">회원가입</button>
		</form>
</section>

<script>
	$("#dupId").click(chekDupId);
	function chekDupId(){

		$.ajax({ 
			url:"<%=request.getContextPath()%>"+"/dupid.lo"
			, type:"post" // 생략가능 
			, async:false // 생략가능 true 가 default 값
			, data: {id:$("input[type= text]").first().val()} // 생략가능, 위 input 의 id란에 적힌 값($("input[type= text]").first().val() 이건 읽기) 
			, success: function(result){
				console.log(result);
				if(result==1){
					$("#dupId").next().html("중복데이터");
					$("#dupId").next().css("color", "red");
				}else{
					$("#dupId").next().html("사용가능");
					$("#dupId").next().css("color", "blue");
				}
			} // 이건 function 형식으로 --> result 라는 데이터를 받겠다 , ==4번(성공) , ==200번 (완성)
			, error: function(request, status, error){
				alert(request.status);
			} // 이건 function 형식으로 ==> != 4 , != 200
		}); // 앞의 객체 이름 == $(jquery) , ajax 실행 ==> key:value, type, async 형태 ==> ==4 
	}
</script>

</body>
</html>