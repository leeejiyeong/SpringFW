package co.yedam.exam.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.yedam.exam.shop.service.ShopService;

@RestController
public class RestShopController {
	@Autowired
	private ShopService shopService;
	
	@GetMapping("/ajaxShopIdCheck.do")
	public String ajaxShopIdCheck(String id) {
		boolean b = shopService.isIdCheck(id);
		String str = "false";
		if(b) str ="true";
		return str;
	}
}
