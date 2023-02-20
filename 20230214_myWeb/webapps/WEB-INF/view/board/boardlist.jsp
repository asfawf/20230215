<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
    <h1>게시글 목록</h1>
    <c:set var="ccc" value="3000"></c:set>
    ${ccc }    
	<table> 
		<tr> 
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성시간</td>
			<td>조회수</td>
		</tr>
		
    <c:forEach items="${boardlist }" var="vo" varStatus="s">
    <!-- 위의건 jstl 로 지정 -->
    	<c:if test="${s.count % 2 ==1 }">
    	<tr style="{background:red}"> </tr> 
    	</c:if>
    	<c:if test="${s.count % 2 == 0 }">
    	<tr style="{background:#ccc}"> </tr> 
    	</c:if>
    	<tr> 
			<td>&nbsp;<a href="?=${vo.boardNum}" style="text-decoration: none; color: black;">${vo.boardNum }: ${s.count }: ${s.index }</a></td>
			<td>${vo.boardTitle }</td>
			<td>&nbsp;&nbsp;&nbsp;${vo.boardWriter }</td>
			<td>&nbsp;&nbsp;&nbsp;${vo.boardDate }</td>
			<td>&nbsp;&nbsp;&nbsp;${vo.boardReadcount }</td>
		</tr>
    </c:forEach>
    </table>
    
    <div>
    	<h3>페이지 처리</h3>
    	<div>
    		
    		<c:if test="${startPageNum > 1 }">
    			<span>&nbsp;&nbsp;이전&nbsp;&nbsp;</span>
    		</c:if>
    		
    		<c:forEach begin="${startPageNum }" end="${endPageNum }" step="1" var="page">
    			<c:choose>
    				<c:when test="${page == currentPage }">
    					<span><b>&nbsp;&nbsp;${page }&nbsp;&nbsp;</b></span>
    				</c:when>
    				<c:otherwise>
    					<span><a href="<%=request.getContextPath() %>/?aaa=${page }"> &nbsp;&nbsp;${page }&nbsp;&nbsp; </a></span>
    				</c:otherwise>
    			</c:choose>
    		</c:forEach>
    	
    		<c:if test="${ endPageNum < pageCnt}">
    			<span>&nbsp;&nbsp;다음&nbsp;&nbsp;</span>
    		</c:if>
    	
    		<!-- 
    			req.setAttribute("startPageNum", startPageNum);
				req.setAttribute("endPageNum", endPageNum);
				req.setAttribute("currentPage", currentPage);
				req.setAttribute("pageCnt", pageCnt);
    		
    		 -->
    	</div>
    </div>
    <hr>
</section>