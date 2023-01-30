package co.micol.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.micol.prj.member.service.MemberService;

@RestController		//호출한 페이지로 결과를 돌려줌(ajax, api호출할때 주로 사용)
public class MemberRestController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/ajaxIdCheck.do")
	public String ajaxIdCheck(String id) {
		boolean b = memberService.isIdCheck(id);	//결과 1: ture, 결과 0: false
		String str = "true";	//존재하면 (존재하냐 물은거라서) -> 사용불가
		if(!b) {
			str = "false";		//존재하지 않으면 -> 사용가능
		}
		return str;		
		//삼항연산자 사용시 -> String str = (b == true) ? "true" : "false";
	}
	
	
}
