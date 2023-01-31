package co.micol.prj.shop.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopCustomerVO {		//shopMember의 자식

	private String shCustomerId;
	private String shCustomerName;
	private String shCustomerTel;
	
	private ShopMemberVO shopMember;	//객체 중심으로 설계할때(VO. 즉, 오브젝트 타입의 -> shopMember)
}
