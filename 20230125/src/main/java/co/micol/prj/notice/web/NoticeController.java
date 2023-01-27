package co.micol.prj.notice.web;

import java.io.File;
import java.net.URLDecoder;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;
import oracle.jdbc.proxy.annotation.Post;

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

		if (!file.isEmpty()) { 			// 첨부 파일이 존재할때만 로직 실행

			// 파일이름 같을때 충돌방지를 위해서 UUID사용
			String fileName = UUID.randomUUID().toString();
			fileName = fileName + file.getOriginalFilename();

			File uploadFile = new File(saveFolder, fileName); // 변수로 경로랑 파일이름
			try {
				file.transferTo(uploadFile); // 파일 저장
			} catch (Exception e) {
				e.printStackTrace();
			}
			vo.setNoticeFile(file.getOriginalFilename()); // 원본파일명
			vo.setNoticeFileDir(saveFolder + fileName); // 물리적 파일 저장 위치(경로 + 파일이름)
		}

		noticeService.noticeInsert(vo); // db에 저장하기

		return "redirect:noticeList.do";
	}

	@RequestMapping("/noticeUpdate.do")
	public String noticeUpdate(NoticeVO vo, Model model) { // model에 태워서 보내야 되니까 적어줌
		model.addAttribute("notice", noticeService.noticeSelect(vo));

		return "notice/noticeUpdate";
	}

	@PostMapping("/noticeDelete.do")
	public String noticeDelete(NoticeVO vo, Model model) { // model은 메시지를 띄우기 위해 필요. 안할꺼면 noticeVO만 써도됨
		File file = new File(vo.getNoticeFileDir());
        boolean result = file.delete();
		int n = noticeService.noticeDelete(vo);
		if (n != 0) {
			model.addAttribute("message", "정상적으로 삭제되었습니다.");
		} else {
			model.addAttribute("message", "정상적으로 삭제되지 못했습니다.");
		}
		return "notice/noticeMessage"; // 삭제 후 메시지 출력
	}

	// String말고 modelAndView객체 사용(최근엔 권장하지 않는 방법)
	@PostMapping("/noticeEdit.do")

	public ModelAndView noticeEdit(NoticeVO vo, ModelAndView mv, MultipartFile file) {
		
		//첨부파일을 수정할수도 있으니까 위에 insert에서 적었던거 다시 적어줌
		String saveFolder = ServletContext.getRealPath("/resources/upload"); // 파일 저장경로 설정
		System.out.println("=============1");
		if (!file.isEmpty()) { // 첨부 파일이 존재할때만 로직 실행
			System.out.println("=============2");
			// 파일이름 같을때 충돌방지를 위해서 UUID사용
			String fileName = UUID.randomUUID().toString();
			fileName = fileName + file.getOriginalFilename();

			File uploadFile = new File(saveFolder, fileName); // 변수로 경로랑 파일이름
			try {
				file.transferTo(uploadFile); // 파일 저장
			} catch (Exception e) {
				e.printStackTrace();
			}
			vo.setNoticeFile(file.getOriginalFilename()); // 원본파일명
			vo.setNoticeFileDir(saveFolder + fileName); // 물리적 파일 저장 위치(경로 + 파일이름)
		}
		
		//❗❗ 파일수정할때 첨부파일이 바뀌면 기존의 첨부파일을 지워야되는데 그건 어케할거임?
		
		int n = noticeService.noticeUpdate(vo); // db 데이터가 수정됨
		System.out.println("=============3");
		if (n != 0) { // 성공했을때 돌려줄페이지
			mv.addObject("notice", noticeService.noticeSelect(vo));
			mv.setViewName("notice/noticeSelect");
		} else { // 실패했을때 돌려줄페이지
			mv.addObject("message", "정상적으로 수정되지 못했습니다.");
			mv.setViewName("notice/noticeError");
		}
		return mv;
	}
	/*
	 * //같은방법 Model사용
	 * 
	 * @PostMapping("/noticeEdit.do") public String noticeEdit(NoticeVO vo, Model
	 * model) { String viewPage = null; int n = noticeService.noticeUpdate(vo); //db
	 * 데이터가 수정됨 if(n != 0) { //성공했을때 돌려줄페이지 model.addAttribute("notice",
	 * noticeService.noticeSelect(vo)); viewPage = "notice/noticeSelect"; }else { //
	 * 실패했을때 돌려줄페이지 model.addAttribute("message", "정상적으로 수정되지 못했습니다."); viewPage =
	 * "notice/noticeError"; } return viewPage; }
	 */
	
	//업로드 파일 삭제
	/*
	 * @PostMapping("/removeFile") public ResponseEntity<Boolean> removeFile(String
	 * fileName){ String srcFileName = null; srcFileName =
	 * URLDecoder.decode(fileName,"UTF-8");
	 * 
	 * File file = new File(uploadPath + )
	 * 
	 * }
	 */
	
}
