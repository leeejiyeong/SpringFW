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
			<h1>직원 리스트</h1>
		</div>
		<div>
			<form id="frm" method="post">
				<div>
					<table border="1">
						<thead>
							<tr>
								<th width="100">이름</th>
								<th width="100">부서</th>
								<th width="100">입사일</th>
								<th width="100">퇴사일</th>
								<th width="100">직급</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${employees }" var="e">
								<tr>
									<td align="center">${e.shEmpName }</td>
									<td align="center">${e.shEmpDpt }</td>
									<td align="center">${e.shEmpStartDate }</td>
									<td align="center">${e.shEmpEndDate }</td>
									<td align="center">${e.shEmpRank }</td>
								<tr>
							</c:forEach>
						</tbody>
					</table>
				</div>


			</form>
		</div>

	</div>
</body>
</html>