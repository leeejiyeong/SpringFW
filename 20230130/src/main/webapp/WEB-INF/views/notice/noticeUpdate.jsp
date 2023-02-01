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
<!-- 작성자 input에서 value=$name인 이유 : memberController에서 내보낼때 변수를 name이라고 지정했기 때문
	$notice.noticeWriter써도 무방함 
	수정 눌렀을때 누른 글 내용 보이게 하려면 value값으로 집어넣으면 된다. $notice.noticeTitle같은 형식으로.
	-->
	<div align="center">
		<div>
			<h1>게시글 수정</h1>
		</div>
		<form id="frm" method="post" enctype="multipart/form-data">
			<div>
				<table border="1">
					<tr>
						<th width="150">작성자</th>
						<td width="200">
							<input type="text" id="noticeWriter"
							name="noticeWriter" value="${notice.noticeWriter}" readonly="readonly">
						</td>
						<th width="150">작성일자</th>
						<td width="200">
							<input type="date" id="noticeDate"
							name="noticeDate" value="${notice.noticeDate }" required="required"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" size="70" id="noticeTitle"
							name="noticeTitle" value="${notice.noticeTitle }" required="required"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea rows="10" cols="75"
								id="noticeSubject" name="noticeSubject">${notice.noticeSubject }</textarea></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3">
							<c:if test="${empty notice.noticeFile }">
								<input type="file" id="file" name="file">
							</c:if>
							<c:if test="${not empty notice.noticeFile }">
								${notice.noticeFile }
								<input type="button" value="수정" onclick="">
								<input type="button" value="삭제" onclick="">
							</c:if>
						</td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<input type="hidden" name="noticeId" value="${notice.noticeId }">
				<input type="button" value="수정완료" onclick="update()"> 
				<input type="button" value="취소" onclick="location.href ='./noticeList.do'">
			</div>
		</form>
	</div>
</body>

<script type="text/javascript">
	function loaded(){
		let message = "${message}";		//model에서 넘어온 변수
		if(message != ""){
			alert(message);
		}
	}
	
	//ajax로 할때는 폼에 action태그가 없어야하고 버튼도 submit이 아닌 button으로 바꿔줘야함(button onclick으로 작동하게)
	function update(){
		//데이터 set
		
// 		fetch(url,{
			
// 		}).then(response => alert(response.text()));
	}
	
</script>
</html>