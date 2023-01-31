package co.micol.prj.shop.vo;

import co.micol.prj.common.PageVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopMemberVO extends PageVO{		//상위필드. MasterVO
	private String shId;
	private String shPassword;
	private String shGubun;
}
