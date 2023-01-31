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
			<form id="frm" onsubmit="return formsubmit()" method="POST">
				<div>
					<table border="1">
						<tr>
							<th>아이디</th>
							<td><input type="text" id="shId" name="shId" required="required">
							<button type="button" id="idChk" value="no" onclick="idCheck()"> 중복체크 </button>
							</td>
						</tr>
						<tr>
							<th>패스워드</th>
							<td><input type="password" id="shPassword" name="shPassword" required="required"></td>
						</tr>
						<tr>
							<th>패스워드 확인</th>
							<td><input type="password" id="shPasswordCheck" name="shPasswordCheck"></td>
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
								<td><input type="text" id="" name=""></td>
							</tr>
							<tr>
								<th>연락처</th>
								<td><input type="tel" id="" name=""></td>
							</tr>
						</table>
					</div>
				</div><br>
				<input type="submit" value="등록"> &nbsp;
				<input type="reset" value="취소">
			</form>
		</div>
	</div>
	
	<script type="text/javascript">
	function showDiv(n){
		if(n == 'C'){
			document.getElementById('customer').setAttribute('style','display:block')
			document.getElementById('user').setAttribute('style','display:none')
			document.getElementById('employee').setAttribute('style','display:none')
		}else if(n=='U'){
			document.getElementById('customer').setAttribute('style','display:none')
			document.getElementById('user').setAttribute('style','display:block')
			document.getElementById('employee').setAttribute('style','display:none')
		}else if(n=='E'){
			document.getElementById('customer').setAttribute('style','display:none')
			document.getElementById('user').setAttribute('style','display:none')
			document.getElementById('employee').setAttribute('style','display:block')
		}
	}
	
	function idCheck(){
		let id = document.getElementById("shId").value;
		fetch("ajaxShopIdCheck.do?id="+id)
			.then(response => response.text())
			.then(data => idCheckResult(data));
	}
	
	function idCheckResult(data){
		if(data == "true"){
			alert("이미 사용중인 아이디 입니다.")
			document.getElementById('shId').value ="";
		}else if(data == "false"){
			alert("사용 가능한 아이디 입니다.")
			document.getElementById("idChk").value = "yes";
		}
	}
	
	function formsubmit(){
		
		if(frm.idChk.value == 'no'){
			alert('아이디 중복체크를 하세요');
			return false;
		}else if(frm.shPassword.value != frm.shPasswordCheck.value){
			alert("비밀번호가 일치하지 않습니다. 다시 확인해주세요")
			return false;
		}
		return true;
		
// 		let option = document.getElementById("shGubun").value;
// 		let option = document.querySelector("input[name='shGubun']:checked").value;
		let option = document.querySelector("#shGubun:checked").value;
		
		if(option == 'C'){
			if(frm.shCustomerName.value ==""){
				alert("사용자 이름을 입력하세요");
				frm.shCustomerName.focus();
				return false;
			}else if(frm.shCustomerTel.value ==""){
				alert("사용자 연락처를 입력하세요");
				frm.shCustomerTel.focus();
				return false;
			}
			
			frm.action = "shopCustomerJoin.do";
			
		}else if(option == 'U'){
			console.log("상점주주")
			if(frm.shUserName.value ==""){
				alert("대표자 이름을 입력하세요");
				frm.shUserName.focus();
				return false;
			}else if(frm.shUserShopName.value ==""){
				alert("상호명을 입력하세요");
				frm.shUserShopname.focus();
				return false;
			}
			frm.action = "shopUserJoin.do";
			
		}else {
			//폼 체크 구문 작성
			frm.action = "shopEmployeejoin.do"
		}
		
	}
	
	</script>
</body>
</html>