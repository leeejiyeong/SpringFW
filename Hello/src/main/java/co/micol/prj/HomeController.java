package co.micol.prj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")		//루트로 요청이 들어오면 home으로 리턴시켜라
	public String home() {
		return "home";
		
	}
}
