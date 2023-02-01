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
	<h1>고객정보 리스트</h1>
	<c:forEach items="${customers }" var="C">
		${C.SH_ID } : ${C.SH_PASSWORD } : ${C.SH_GUBUN } : ${C.SH_CUSTOMER_NAME } : ${C.SH_CUSTOMER_TEL }<br>
	</c:forEach>
	
	<a href="shopList.do">상점고객 리스트</a><br>
	<a href="getCustomerList.do">객체형태로 고객리스트불러오기</a><br>
	<a href="setMemberJionForm.do">쇼핑몰회원가입</a>
</body>
</html>