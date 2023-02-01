package co.yedam.exam.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.yedam.exam.shop.service.ShopService;
import co.yedam.exam.shop.vo.EmployeeVO;
import co.yedam.exam.shop.vo.ShCustomerVO;
import co.yedam.exam.shop.vo.ShUserVO;
import co.yedam.exam.shop.vo.ShopMemberVO;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	@GetMapping("/customerList.do")
	public String customerList(Model model) {
		model.addAttribute("customers", shopService.getCustomerList());
		return "shop/customerList";
	}
	
	@GetMapping("/shopList.do")
	public String shopList(Model model) {
		model.addAttribute("shops", shopService.getShopList());
		return "shop/shopList";
	}
	
	@GetMapping("/getCustomerList.do")  //객체중심으로 설계 했을때
	public String getCustomerList(Model model) {
		model.addAttribute("customers", shopService.getCustomerList2());
		return "shop/getCustomerList";
	}
	
	@GetMapping("/setMemberJionForm.do")
	public String setMemberJionForm() {
		return "shop/setMemberJionForm";
	}
	
	@PostMapping("/shopCustomerJoin.do")
	public String shopMemberJoin(ShCustomerVO vo, ShopMemberVO svo, Model model) {
		String message = null;
		vo.setShCustomerId(svo.getShId());  //아이디값을 넣는다.
		int n = shopService.setMember(svo);  //멤버에 저장하고
		if(n != 0) {
			int m = shopService.setCustomer(vo);  //개별테이블에 저장
			if(m != 0) {
				message = "회원가입이 정상적으로 처리 되었다.";
			}else {
				message = "회원가입이 실패했습니다.";
			}
		}else {
			message = "회원가입이 실패했습니다.";
		}
		model.addAttribute("message", message);
		return "shop/shopMessage";
	}
	
	@PostMapping("/shopUserJoin.do")
	public String shopUserJoin(ShUserVO vo, ShopMemberVO svo, Model model) {
		String message = null;
		System.out.println(vo.getShId() +"==========");
		System.out.println(svo.getShId());
		model.addAttribute("message", message);
		return "shop/shopMessage";
	}
	
	//Employee
	@GetMapping("/employeeList.do")
	public String employeeList(Model model) {
		model.addAttribute("employees", shopService.employeeList());
		return "shop/employeeList";
	}
	
	@RequestMapping("/shopEmployeeJoin.do")
	public String shopEmployeeJoin(Model model, ShopMemberVO svo, EmployeeVO evo) {  //emp vo 를 넣어주고 동작 시키면 된다.
		String message = null;
		evo.setShEmpId(svo.getShId());
		int n = shopService.setMember(svo);
		if(n != 0) {
			int e = shopService.setEmployee(evo);
			if(e != 0) {
				message = "회원가입이 정상적으로 처리되었습니다.";
			}else {
				message = "회원가입이 정상적으로 처리되지 못했습니다.";
			}
		}else {
			message = "회원가입 실패";
		}
		model.addAttribute("message", message);
		return "shop/shopMessage";
	}
}
