package co.yedam.exam.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.exam.notice.service.NoticeService;
import co.yedam.exam.notice.vo.NoticeVO;

@RestController       //@Controller + @ResponseBody
public class NoticeRestController {
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping(value = "/AjaxSearchList.do", produces = "application/json;charset=UTF-8")
	public String ajaxSearchList(
			@RequestParam("key") String key, 
			@RequestParam("val") String val) {
		String str = null;
		ObjectMapper json = new ObjectMapper();
		try {
			str = json.writeValueAsString(noticeService.noticeSearch(key, val));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	@PostMapping(value = "/AjaxSearchListJson.do",produces = "application/json;charset=UTF-8")
//	public String ajaxSearchListJson(@RequestBody Map<String, String> body) {  //맵을 이용하는 방법
//      String key = body.get("key");
//      String val = body.get("val");
	public String ajaxSearchListJson(@RequestBody NoticeVO vo) {  //vo객체를 이용하는 방법
		String key = vo.getKey();
		String val = vo.getVal();
		
		String str = null;
		ObjectMapper json = new ObjectMapper();
		try {
			str = json.writeValueAsString(noticeService.noticeSearch(key, val));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
