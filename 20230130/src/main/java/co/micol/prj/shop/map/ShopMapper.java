package co.micol.prj.shop.map;

import java.util.List;
import java.util.Map;

import co.micol.prj.shop.vo.ShopCustomerVO;
import co.micol.prj.shop.vo.ShopMemberVO;
import co.micol.prj.shop.vo.ShopUserVO;

//shopService와 동일함
public interface ShopMapper {
	List<Map<String,Object>> getCustomerList();	//고객정보리스트 보기(맵 구조로 받음)
	List<ShopUserVO> getShopList();				//상점주 리스트 보기
	
	List <ShopCustomerVO> getCustomerList2();	//고객정보를 객체로 받아오기
	
	ShopMemberVO loginCheck(ShopMemberVO vo);	//로그인하기 -> 로그인할때 shopMemberVO를 넘긴다.
	boolean isIdCheck(String id);			//아이디 중복체크
	
	int setShopUser(ShopUserVO vo);				//상점주 추가(insert)
	int setCustomer(ShopCustomerVO vo);			//고객정보 추가(insert)
	int setMember(ShopMemberVO vo); 			//아이디, 패스워드 구분 입력
}
