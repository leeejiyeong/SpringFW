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
	<h1>상점고객 리스트</h1>
	<c:forEach items="${shops }" var="s"> 
		${s.shUserId } : ${s.shPassword } : ${s.shUserName } : ${s.shUserShopname } : ${s.shGubun} <br>
	</c:forEach>
</body>
</html>