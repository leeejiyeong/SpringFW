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
		<div>
			<h1>게시글 목록</h1>
		</div>
		<div id="n-list">
			<!-- notices로 넘어오는걸 n으로 읽을거임  -->
			<table border="1">
				<thead>
					<tr>
						<th>작성자</th>
						<th>제목</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${notices }" var="n">
						<tr>
							<td>${n.noticeWriter }</td>
							<td>${n.noticeTitle }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br>

		<!-- 검색창 -->
		<div>
			<form id="frm" method="post">
				<div>
					<table border="1">
						<tr>
							<td width="100"><select name="key" id="key">
									<option value="all">전체</option>
									<option value="title">제목</option>
									<option value="subject">내용</option>
									<option value="writer">작성자</option>
									<option value="date">작성일자</option>
							</select></td>
							<td width="250">
								<input type="text" name="val" id="val">
								&nbsp; <input type="button" onclick="searchList()" value="검색">
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">
	function searchList(){
		let url = 'AjaxSearchList.do';
		let key = document.getElementById("key").value;	//옵션창 고른거 value값이 넘어감
		let val = document.getElementById("val").value;	//검색창에 적은 내용이 넘어감
		
		let payload = 'key='+key+'&val='+val;	//json방식으로 만들어줌
		
		fetch(url, { 
			  method: 'POST',
			  headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			  body: payload
			})
		.then(response => response.json())
		.then(data => htmlConvert(data));
	}
	
	function htmlConvert(data){
		//여기서 화면에 처리하는 과정을 작성하면됨
		console.log(data);
	}
	</script>
</body>
</html>