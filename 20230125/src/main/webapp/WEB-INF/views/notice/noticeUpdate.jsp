<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 작성자 input에서 value=$name인 이유 : memberController에서 내보낼때 변수를 name이라고 지정했기 때문 -->
	<div align="center">
		<div>
			<h1>게시글 수정</h1>
		</div>
		<form id="frm" action="noticeUpdate.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">작성자</th>
						<td width="200"><input type="text" id="noticeWriter"
							name="noticeWriter" value="${name }" readonly="readonly">
						</td>
						<th width="150">작성일자</th>
						<td width="200"><input type="date" id="noticeDate"
							name="noticeDate" required="required"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" size="70" id="noticeTitle"
							name="noticeTitle" required="required"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea rows="10" cols="75"
								id="noticeSubject" name="noticeSubject"></textarea></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3"><input type="file" id="file" name="file">
						</td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<input type="hidden" name="noticeId" value="${notice.noticeId }">
				<input type="submit" value="수정완료"> <input type="reset"
					value="취소"> <input type="button" value="목록으로"
					onclick="location.href ='./noticeList.do'">
			</div>
		</form>
	</div>
</body>
</html>