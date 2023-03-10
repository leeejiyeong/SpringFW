package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@RestController 	
/*
 * @Controller + ResponseBody 합친거랑 같음. 
 * 기존의controller랑 똑같이쓰고 @ResponseBody를 빼버리면됨.
 * 보통 @ResponseBody를 추가하기 번거로워서 합쳐진 이걸 많이 더 많이쓴다.
 */
public class NoticeRestController {

	@Autowired
	NoticeService noticeService;
	
	@RequestMapping(value = "/AjaxSearchList.do", produces = "application/json;charset=UTF-8")
	public String ajaxSearchList(
			@RequestParam("key") String key,
			@RequestParam("val") String val) {
		System.out.println("키캆: "+ key);
		System.out.println("발류값:" + val);
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
	
	@PostMapping(value = "/AjaxSearchListJson.do", produces = "application/json; charset=utf-8")
	//맵을 이용하는 방법
//	public String AjaxSearchListJson(@RequestBody Map<String, String> body) {
//		String key = body.get("key");
//		String val = body.get("val");
	
	//vo객체를 이용하는 방법(추천)
	public String AjaxSearchListJson(@RequestBody NoticeVO vo) {
		String key = vo.getKey();
		String val = vo.getVal();
		
		String str = null;
		ObjectMapper json = new ObjectMapper();
		try {
			str = json.writeValueAsString(noticeService.noticeSearch(key, val));
			System.out.println(str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(str);
		return str;
	}
}
