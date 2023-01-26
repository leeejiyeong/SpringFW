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
		<div>
			<h1>게시글 작성</h1>
		</div>
		<form id="frm" action="noticeInsert.do" method="post" enctype="multipart/form-data">
			<div>
				<table border="1">
					<tr>
						<th width="150">작성자</th>
						<td width="200"><input type="text" name="noticeWriter" id="noticeWriter" value="${name }" readonly="readonly"></td>
						<th width="150">작성일자</th>
						<td width="200"><input type="date" name="noticeDate" id="noticeDate" required="required"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" name="noticeTitle" id="noticeTitle" size="60" required="required"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea rows="3" cols="75" name="noticeSubject" id="noticeSubject"></textarea></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3"><input type="file" name="file" id="file"></td>
					</tr>
				</table>
				<input type="submit" value="저장"> 
				<input type="reset"	value="취소">
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
		
	</script>
</body>
</html>