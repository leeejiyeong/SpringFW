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
	<h1>객체 중심 고객 리스트</h1>
	<c:forEach items="${customers }" var="c">
		${c.shCustomerName } : ${c.shopMember.shId } : ${c.shopMember.shPassword }<br>
	</c:forEach>
</body>
</html>