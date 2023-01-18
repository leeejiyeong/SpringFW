package co.micol.prj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("/memberList.do")
	public String memberList() {
		return "member/memberList";
		
	}
}
