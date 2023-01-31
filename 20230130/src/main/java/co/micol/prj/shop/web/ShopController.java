package co.micol.prj.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.shop.service.ShopService;
import co.micol.prj.shop.vo.ShopCustomerVO;
import co.micol.prj.shop.vo.ShopMemberVO;
import co.micol.prj.shop.vo.ShopUserVO;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;

	@GetMapping("/CustomerList.do") // 리스트는 무조건 getMapping임
	public String customerList(Model model) {
		model.addAttribute("customers", shopService.getCustomerList());
		return "shop/customerList";
	}

	@GetMapping("/shopList.do")
	public String shopList(Model model) {
		model.addAttribute("shops", shopService.getShopList());
		return "shop/shopList";
	}

	@GetMapping("/getCustomerList2.do") // 객체로 설계했을때 - 객체 형태로 고객리스트 불러오기
	public String getCustomerList2(Model model) {
		model.addAttribute("customers", shopService.getCustomerList2());
		return "shop/getCustomerList2";
	}

	@RequestMapping("/setMemberJoinForm.do") // 폼 호출하는것도 getmapping임
	public String setMemberJoinForm() {
		return "shop/setMemberJoinForm";
	}

	@RequestMapping("/shopCustomerJoin.do")
	public String shopMemberJoin(ShopCustomerVO vo, ShopMemberVO svo, Model model) {
		System.out.println("========================1");
		String message = null;
		vo.setShCustomerId(svo.getShId());			// 아이디값을 넣는다
		int n = shopService.setMember(svo);			// 멤버를 저장하고
		if (n != 0) {
			int m = shopService.setCustomer(vo); 	// 개별테이블에 저장
			if (m != 0) {
				message = "회원가입이 정상적으로 완료되었다.";
			} else {
				message = "회원ㄱㅏ입 실패";
			}
		}
		model.addAttribute("message", message);
		return "shop/shopMessage";
	}

	@RequestMapping("/shopUserJoin.do")
	public String shopUserJoin(ShopUserVO vo, ShopMemberVO svo, Model model) {
		String message = null;
		System.out.println(vo.getShUserId() +"=========");
		System.out.println(svo.getShId() +"-----------");

		model.addAttribute("message", message);
		return "shop/shopMessage";
	}

	@RequestMapping("/shopEmployeerJoin.do")
	public String shopEmployeeJoin(Model model, ShopMemberVO svo) { // emp vo를 넣어주고 동작시키면 됨.
		String message = null;

		model.addAttribute("message", message);
		return "shop/shopMessage";
	}
}
