package co.micol.prj.shop.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopUserVO extends ShopMemberVO{
	private String shUserId;
	private String shUserName;
	private String shUserShopname;
}
