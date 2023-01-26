<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 여기서 name은 vo객체랑 똑같이 써야함 -->
<div align="center">
	<div><h1>로그인</h1></div>
	<div>
		<form id="frm" action="memberLogin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">*아이디</th>
						<td width="200">
							<input type="text" id="memberId" name="memberId">
						</td>
					</tr>
					<tr>
						<th>*비밀번호</th>
						<td>
							<input type="password" id="memberPassword" name="memberPassword">
						</td>
					</tr>
				</table>
			</div><br>
				<input type="submit" value="Login"> &nbsp;&nbsp;
				<input type="reset" value="cancel"> 
		</form>
	</div>
</div>
</body>
</html>