<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>게시글 상세내역</h1></div>
		<div>
			<table border="1">
				<tr>
					<th width="150">작성자</th>
					<td width="200">${notice.noticeWriter }</td>
					<th width="150">작성일자</th>
					<td width="200">${notice.noticeDate }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3">${notice.noticeTitle }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"><textarea rows="10" cols="75">${notice.noticeSubject}</textarea>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3">${notice.noticeFile }</td>
				</tr>
			</table>
		</div>
		<br>
		<div>
			<form id="frm" method="post">
				<c:if test="${name eq notice.noticeWriter }">
					<button type="button" onclick="location.href='noticeUpdate.do'">글 수정</button>
					<button type="button" onclick="#">글 삭제</button>
				</c:if>
					<button type="button" onclick="location.href ='./noticeList.do'">뒤로가기</button>
				<input type="hidden" name="noticeId" value="${notice.noticeId }">
			</form>
		</div>
	</div>
	<!-- $name인 이유 : memberController에서 내보낼때 변수를 name이라고 지정했기 때문 
		eq: el표현식에서 사용하는 연산자. ==과 같다.
	-->
</body>
</html>