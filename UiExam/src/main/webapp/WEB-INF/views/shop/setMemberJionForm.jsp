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
			<h1>쇼핑몰 회원가입</h1>
		</div>
		<div>
			<form id="frm" onsubmit="return formSubmit()" method="post">
				<div>
					<table border="1">
						<tr>
							<th>아이디</th>
							<td><input type="text" id="shId" name="shId" required="required">
							<button type="button" id="idCheck" value="no" onclick="idcheck()">중복체크</button></td>
						</tr>
						<tr>
							<th>패스워드</th>
							<td><input type="password" id="shPassword" name="shPassword" required></td>
						</tr>
						<tr>
							<th>패스워드 확인</th>
							<td><input type="password" id="shPasswordCheck" name="shPasswordCheck" required="required"></td>
						</tr>
						<tr>
							<th>구분</th>
							<td>
								<input type="radio" id="shGubun" name="shGubun" value="C" onchange="showDiv('C')" checked="checked">고객
								<input type="radio" id="shGubun" name="shGubun" value="U" onchange="showDiv('U')">상점주
								<input type="radio" id="shGubun" name="shGubun" value="E" onchange="showDiv('E')">직원
							</td>
						</tr>
					</table>
					<div id="customer" style="display: block;">
						<table>
							<tr>
								<th>이름</th>
								<td><input type="text" id="shCustomerName" name="shCustomerName"></td>
							</tr>
							<tr>
								<th>연락처</th>
								<td><input type="tel" id="shCustomerTel" name="shCustomerTel"></td>
							</tr>
						</table>
					</div>
					<div id="user" style="display: none;">
						<table>
							<tr>
								<th>대표이름</th>
								<td><input type="text" id="shUserName" name="shUserName"></td>
							</tr>
							<tr>
								<th>상호명</th>
								<td><input type="text" id="shUserShopname" name="shUserShopname"></td>
							</tr>
						</table>
					</div>
					<div id="employee" style="display: none;">
						<table>
							<tr>
								<th>이름</th>
								<td><input type="text" id="shEmpName" name="shEmpName" required="required"></td>
							</tr>
							<tr>
								<th>부서</th>
								<td>
									<select id="shEmpDpt" name="shEmpDpt">
										<option value="관리부">관리부</option>
										<option value="마케팅부">마케팅부</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>입사일</th>
								<td><input type="date" id="shEmpStartDate" name="shEmpStartDate" required="required"></td>
							</tr>
							<tr>
								<th>퇴사일</th>
								<td><input type="date" id="shEmpEndDate" name="shEmpEndDate" required="required"></td>
							</tr>
							<tr>
								<th>직급</th>
								<td>
									<select id="shEmpRank" name="shEmpRank">
										<option value="팀원">팀원</option>
										<option value="팀장">팀장</option>
									</select>
								</td>
							</tr>
						</table>
					</div>
				</div><br>
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="취소">
			</form>
		</div>
	</div>
	<script>
	function showDiv(option){
		if(option == 'C'){
			document.getElementById('customer').setAttribute('style','display:block')
			document.getElementById('user').setAttribute('style','display:none')
			document.getElementById('employee').setAttribute('style','display:none')
		}else if(option == 'U'){
			document.getElementById('customer').setAttribute('style','display:none')
			document.getElementById('user').setAttribute('style','display:block')
			document.getElementById('employee').setAttribute('style','display:none')
		}else if(option == 'E'){
			document.getElementById('customer').setAttribute('style','display:none')
			document.getElementById('user').setAttribute('style','display:none')
			document.getElementById('employee').setAttribute('style','display:block')
		}
	}
	
	function idcheck() {
		let id = document.getElementById("shId").value;
		fetch("ajaxShopIdCheck.do?id="+id)
			.then(response => response.text())
			.then(data => idCheckResult(data));
	}
	
	function idCheckResult(data) {
		if(data == "true") {
			alert("이미 사용하는 아이디 입니다.");
		}else if(data == "false"){
			alert("사용가능한 아이디 입니다.");
			document.getElementById("idCheck").value="yes";
		}
	}
	
	function formSubmit() {
//		let option = document.querySelector('input[name="shGubun"]:checked').value;
		let option = document.querySelector('#shGubun:checked').value;
		if(frm.idCheck.value == 'no') {
			alert("아이디 중복체크를 해주세요");
			return false;
		}else if(frm.shPassword.value != frm.shPasswordCheck.value) {
			alert("패스워드를 확인해주세요.");
			return false; 
		}
				
		if (option == 'C') {
			if(frm.shCustomerName.value =="") {
				alert("사용자 이름을 입력하세요");
				frm.shCustomerName.forcus();
				return false;
			}else if(frm.shCustomerTel.value==""){
				alert("사용자 전화번호를 입력하세요");
				frm.shCustomerTel.forcus();
				return false;
			}
			frm.action = "shopCustomerJoin.do";
		}else if(option == 'U') {
			if(frm.shUserName.value =="") {
				alert("대표자 이름을 입력하세요");
				frm.shUserName.forcus();
				return false;
			}else if(frm.shUserShopname.value==""){
				alert("상호명을 입력하세요");
				frm.shUserShopname.forcus();
				return false;
			}
			frm.action = "shopUserJoin.do";
		}else {
			//폼 체크 구문 작성
			if(frm.shEmpName.value == ""){
				alert("이름을 입력하세요")
				frm.shEmpName.forcus();
				return false;
			}else if(frm.shEmpDpt.value == ""){
				alert("부서를 입력하세요")
				frm.shEmpDpt.forcus();
				return false;
			}else if(frm.shEmpStartDate.value == ""){
				alert("입사일을 선택하세요")
				frm.shEmpStartDate.forcus();
				return false;
			}else if(frm.shEmpEndDate.value == ""){
				alert("입사일을 선택하세요")
				frm.shEmpEndDate.forcus();
				return false;
			}else if(frm.shEmpRank.value == ""){
				alert("직급을 입력하세요")
				frm.shEmpRank.forcus();
				return false;
			}
			frm.action = "shopEmployeeJoin.do";
		}	
		return true;
	}
	</script>
</body>
</html>