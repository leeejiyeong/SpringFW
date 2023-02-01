package co.yedam.exam.shop.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShCustomerVO {  //shopmember 자식
	private String shCustomerId;
	private String shCustomerName;
	private String shCustomerTel;
	
	private ShopMemberVO shopMember;  //객체 중심으로 설계할때
}
