<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							<td width="250"><input type="text" name="val" id="val">
								&nbsp; <input type="button" onclick="searchListJson()" value="검색">
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<hr>

		<!-- 공지 목록 -->
		<div id="n-list">
			<!-- notices로 넘어오는걸 n으로 읽을거임  -->
			<table border="1">
				<thead>
					<tr>
						<th width="100">순번</th>
						<th width="250">제목</th>
						<th width="150">작성자</th>
						<th width="150">작성일자</th>
						<th width="100">조회수</th>
						<th width="100">첨부파일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${notices }" var="n">
						<tr style='cursor: pointer;'
							onmouseover='this.style.background="#fcecae";'
							onmouseleave='this.style.background="#FFFFFF";'
							onclick="noticeSel(${n.noticeId })">
							<td align="center">${n.noticeId }</td>
							<td align="center">${n.noticeTitle }</td>
							<td align="center">${n.noticeWriter }</td>
							<td align="center">${n.noticeDate }</td>
							<td align="center">${n.noticeHit }</td>
							<td align="center"><c:if test="${not empty n.noticeFile }"> 💾 </c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br>
		<div>
			<c:if test="${not empty id}">
				<button type="button" onclick="location.href='noticeInsertForm.do'">글쓰기</button>
			</c:if>
		</div>

		<!-- 게시글 상세보기를 위한 히든 폼 -->
		<div>
			<form id="hiddenFrm" action="noticeSelect.do" method="post">
				<input type="hidden" name="noticeId" id="noticeId">
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
	
	//json을 html로 변환해서 화면에 뿌림
	function htmlConvert(data){
		document.querySelector('#notice-list').remove();  //리스트의 <tbody> 삭제
		const container = document.createElement('tbody'); //<tbody> 태그 생성
		container.id = 'notice-list';  //tbody id값 부여
		container.innerHTML = datas.map(data => createHTMLString(data)).join("");  //Html 변환
		document.querySelector('#list-table').appendChild(container);  //원하는 위치에 추가
	
		console.log(data);
	}
	
	function createHTMLString(data){  //html 변환 코드 css, event Listner를 활용하면 깔끔하게 정리됨
		if(data.noticeFile == null) //첨부파일 존재유무 확인
			data.noticeFile = ""  //존재하지 않으면 공백
		else 
			data.noticeFile = "@"; //존재하면 @로 표시
	
		let str = "<tr onmouseover=this.style.background='#fcecae';"
			str += " onmouseleave=this.style.background='#FFFFFF';"  //앞 쪽 공백 주의
			str += " onclick=";  //앞 쪽 공백 주의
			str += "noticeSel('"+ data.noticeId +"')" +">";
			str += "<td align=center>" + data.noticeId + "</td>";
			str += "<td>" + data.noticeTitle + "</td>";
			str += "<td align=center>" + data.noticeWriter + "</td>";
			str += "<td align=center>" + data.noticeDate + "</td>";
			str += "<td align=center>" + data.noticeHit + "</td>";
			str += "<td align=center>" + data.noticeFile + "</td></tr>";
		return str;
	}
	
	//게시글 상세보기 클릭 이벤트
	function noticeSel(n){
		document.getElementById("noticeId").value = n;	//noticeId의 값을 n에 담아줌
		hiddenFrm.submit();
	}
	
	function searchListJson(){
		let url = 'AjaxSearchList.do';
		let key = document.getElementById("key").value;	//옵션창 고른거 value값이 넘어감
		let val = document.getElementById("val").value;	//검색창에 적은 내용이 넘어감
		
		let payload = {"key": key, "val": val};	
		
		fetch(url, { 
			  method: 'POST',
			  headers: {'Content-Type': 'application/json'},
			  body: JSON.stringify(payload)
			})
		.then(response => response.json())
		.then(data => htmlConvert(data));
	}
	</script>
</body>
</html>