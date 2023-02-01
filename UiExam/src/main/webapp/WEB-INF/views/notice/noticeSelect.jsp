<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>공지사항 등록</h1></div>
	<div>
		<form id="frm" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="100">작성자</th>
						<td width="150" align="center">${notice.noticeWriter }</td>
						<th width="100">작성일자</th>
						<td width="150" align="center">${notice.noticeDate }</td>
						<th width="100">조회수</th>
						<td width="50" align="center">${notice.noticeHit }</td>
					</tr>
					<tr>
						<th>제 목</th>
						<td colspan="5">${notice.noticeTitle }</td>
					</tr>
					<tr>
						<th>내 용</th>
						<td colspan="5">
							<textarea rows="10" cols="80">${notice.noticeSubject }</textarea>
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="5">${notice.noticeFile }</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="hidden" name="noticeId" id="noticeId" value="${notice.noticeId }">
				<input type="button" value="수정" onclick="noticeEdit('U')">&nbsp;&nbsp;&nbsp;
				<input type="button" value="삭제" onclick="noticeEdit('D')">&nbsp;&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='noticeList.do'">
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	function noticeEdit(state){
		if(state == 'U') {
			frm.action = "noticeUpdate.do";
		}else {
			frm.action = "noticeDelete.do";
		}
		
		frm.submit();
	}
</script>
</body>
</html>