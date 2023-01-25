package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.notice.service.NoticeService;

@Controller // 나는 컨트롤러야 라고 알려주기
public class NoticeController {
	
	@Autowired	//service에 등록한 noticeService를 자동으로 가져와서 쓸것이다.
	NoticeService noticeService;
	
	@RequestMapping("/noticeList.do") 		// noticeList.do로 들어오면
	public String noticeList(Model model) { //메소드에 의한 의존주입
		//model객체에 db결과를 실어서 보냄
		model.addAttribute("notices", noticeService.noticeList()); //list타입으로(noticeList가 리스트타입이니까) "notices"라는 변수에 담긴다
		
		return "notice/noticeList";
	}
	/*
	//===ajax===
	@RequestMapping(value = "/AjaxSearchList.do", produces = "application/json;charset=UTF-8")
	//@RequestMapping("/AjaxSearchList.do")
	
	@ResponseBody 	//호출한 페이지에 결과를 돌려준다. 밑에 public @ResponseBody String ajaxSearchList 이렇게 써도됨
	public String ajaxSearchList(
			@RequestParam("key") String key,
			@RequestParam("val") String val) {
		System.out.println("키"+key);
		System.out.println("발"+val);
		String str = null;
		ObjectMapper json = new ObjectMapper();
		try {
			str = json.writeValueAsString(noticeService.noticeSearch(key, val));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(str);
		return str;
	}
	
	
	*/
}
