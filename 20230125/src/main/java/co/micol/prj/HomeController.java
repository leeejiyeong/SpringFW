package co.micol.prj;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	/*매소드 오버로딩 :  동일한 메소드명으로 매개변수 타입이나 전달인자 타입, 갯수 또는 리턴밸류에 따라 같은 메소드지만 다른역할을 하는것(폴리모리즘. 다형성)
	 * 위에 쓴 메소드를 변수를 넣지 않고 다시 쓸수있다(?)
	*/
	@RequestMapping("home.do")
	public String home() {
		return "home";
	}
	
}
