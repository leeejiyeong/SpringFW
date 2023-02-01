package co.yedam.exam.shop.map;

import java.util.List;
import java.util.Map;

import co.yedam.exam.shop.vo.EmployeeVO;
import co.yedam.exam.shop.vo.ShCustomerVO;
import co.yedam.exam.shop.vo.ShUserVO;
import co.yedam.exam.shop.vo.ShopMemberVO;

public interface ShopMapper {
	List<Map<String, Object>> getCustomerList();  	//고객정보리스트 보기(맵 구조로 받음)
	List<ShUserVO> getShopList();  					//상점주 리스트 보기
	
	List<ShCustomerVO> getCustomerList2(); 			//고객정보를 객체로 받아오기
	
	ShopMemberVO loginCheck(ShopMemberVO vo);  		//로그인 하기
	boolean isIdCheck(String id);  					//아이디 중복체크
	
	int setShopUser(ShUserVO vo);  					//상점주 추가
	int setCustomer(ShCustomerVO vo);  				//고객 정보 추가
	int setMember(ShopMemberVO vo);      			//아이디 패스워드 구분 입력
	
	//Employee
	List<EmployeeVO> employeeList();				//직원 리스트
	int setEmployee(EmployeeVO vo);					//직원 추가
}
