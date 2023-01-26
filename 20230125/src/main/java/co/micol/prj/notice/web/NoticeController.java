package co.micol.prj.notice.web;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller // 나는 컨트롤러야 라고 알려주기
public class NoticeController {

	@Autowired // service에 등록한 noticeService를 자동으로 가져와서 쓸것이다.
	NoticeService noticeService;

	@Autowired
	ServletContext ServletContext; // 실제 경로를 가져오기 위해 사용함(파일 업로드시 사용)

	@RequestMapping("/noticeList.do") // noticeList.do로 들어오면
	public String noticeList(Model model) { // 메소드에 의한 의존주입
		// model객체에 db결과를 실어서 보냄
		model.addAttribute("notices", noticeService.noticeList()); // list타입으로(noticeList가 리스트타입이니까) "notices"라는 변수에 담긴다

		return "notice/noticeList";
	}
	/*
	 * //===ajax===
	 * 
	 * @RequestMapping(value = "/AjaxSearchList.do", produces =
	 * "application/json;charset=UTF-8") //@RequestMapping("/AjaxSearchList.do")
	 * 
	 * @ResponseBody //호출한 페이지에 결과를 돌려준다. 밑에 public @ResponseBody String
	 * ajaxSearchList 이렇게 메소드 안에다가 써도됨 public String ajaxSearchList(
	 * 
	 * @RequestParam("key") String key,
	 * 
	 * @RequestParam("val") String val) { System.out.println("키"+key);
	 * System.out.println("발"+val); String str = null; ObjectMapper json = new
	 * ObjectMapper(); try { str =
	 * json.writeValueAsString(noticeService.noticeSearch(key, val)); } catch
	 * (JsonProcessingException e) { e.printStackTrace(); } System.out.println(str);
	 * return str; }
	 * 
	 */

	@PostMapping("/noticeSelect.do")
	public String noticeSelect(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeService.noticeSelect(vo));
		return "notice/noticeSelect";
	}

	@RequestMapping("/noticeInsertForm.do")
	public String noticeInsertForm() {
		return "notice/noticeInsertForm";
	}

	@RequestMapping("/noticeInsert.do") // 정확하게는 @postmapping이다 (포스트방식으로 날아오니까)
	public String noticeInsert(NoticeVO vo, MultipartFile file) {
		String saveFolder = ServletContext.getRealPath("/resources/upload"); // 파일 저장경로 설정
		
		if (!file.isEmpty()) {			//첨부 파일이 존재할때만 로직 실행
			
			//파일이름 같을때 충돌방지를 위해서 UUID사용
			String fileName = UUID.randomUUID().toString();
			fileName = fileName + file.getOriginalFilename();
			
			File uploadFile = new File(saveFolder, fileName); // 변수로 경로랑 파일이름
			try {
				file.transferTo(uploadFile); // 파일 저장
			} catch (Exception e) {
				e.printStackTrace();
			}
			vo.setNoticeFile(file.getOriginalFilename()); 	// 원본파일명
			vo.setNoticeFileDir(saveFolder + fileName); 	// 물리적 파일 저장 위치(경로 + 파일이름)
		}
		
		noticeService.noticeInsert(vo); // db에 저장하기

		return "redirect:noticeList.do";
	}
	
	@RequestMapping("/noticeUpdate.do")
	public String noticeUpdate() {
		return "notice/noticeUpdate";
	}
	
}
