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
	<div><h1>회원가입</h1></div>
	<div>
		<form id="frm" action="memberJoin.do" method="post">
			<table>
			<tr>
				<th>아이디*</th>
				<td>
					<input type="text" id="memberId" name="memberId" required>
					<button type="button" id="btn" onclick="idCk()" value="no">중복체크</button>
				</td>
			</tr>
			<tr>
				<th>비밀번호*</th>
				<td>
					<input type="password" id="memberPassword" name="memberPassword" required> 
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인*</th>
				<td>
					<input type="password" id="memberpwck" name="memberpwck" onchange="pwck()" required>
				</td>
			</tr>
			<tr>
				<th>이름*</th>
				<td>
					<input type="text" id="memberName" name="memberName" required>
				</td> 
			</tr>
			<tr>
				<th>나이</th>
				<td>
					<input type="text" id="memberAge" name="memberAge">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" id="memberAddress" name="memberAddress">
				</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>
					<input type="tel" id="memberTel" name="memberTel">
				</td>
			</tr>
			</table>
			<input type="submit" value="회원가입">
			<input type="button" value="뒤로가기" onclick="location.href='home.do'">
		</form>
	</div>
</div>
</body>
</html>