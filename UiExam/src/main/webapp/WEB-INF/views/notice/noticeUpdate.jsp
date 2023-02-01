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
		<form id="frm" action="noticeEdit.do" method="post" enctype="multipart/form-data">
			<div>
				<table border="1">
					<tr>
						<th width="150">작성자</th>
						<td width="200">
							<input type="text" name="noticeWriter" id="noticeWriter" value="${notice.noticeWriter}" readonly="readonly">
						</td>
						<th width="150">작성일자</th>
						<td width="200">
							<input type="date" name="noticeDate" id="noticeDate" value="${notice.noticeDate }" required="required">
						</td>
					</tr>
					<tr>
						<th>제 목</th>
						<td colspan="3">
							<input type="text" name="noticeTitle" id="noticeTitle" size="78" value="${notice.noticeTitle }" required="required">
						</td>
					</tr>
					<tr>
						<th>내 용</th>
						<td colspan="3">
							<textarea name="noticeSubject" id="noticeSubject" rows="10" cols="80">${notice.noticeSubject }
							</textarea>
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3">
							<input type="file" name="file" id="file" value="${notice.noticeFile }">
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
				<input type="button" value="취소" onclick="location.href='noticeList.do'">
			</div>
		</form>
	</div>
</div>
</body>
</html>