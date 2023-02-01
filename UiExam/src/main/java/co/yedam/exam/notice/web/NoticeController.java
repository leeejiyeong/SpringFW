package co.yedam.exam.notice.web;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import co.yedam.exam.notice.service.NoticeService;
import co.yedam.exam.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	ServletContext servletContext; //실 경로를 가져오기 위해사용함
	
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		//Model 객체에 db결과 실어서 보냄
		model.addAttribute("notices", noticeService.noticeList());
		return "notice/noticeList";
	}
	
	@PostMapping("/noticeSelect.do")
	public String noticeSelect(NoticeVO vo, Model model) {
		model.addAttribute("notice",noticeService.noticeSelect(vo));
		return "notice/noticeSelect";
	}
	
	@GetMapping("/noticeInsertForm.do")
	public String noticeInsertForm() {
		return "notice/noticeInsertForm";
	}
	
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile file) {
		String saveFolder = servletContext.getRealPath("/resources/upload/"); //파일저장위치 가져오기
		if(!file.isEmpty()) {  //첨부파일이 존재하면
			String fileName = UUID.randomUUID().toString();
			fileName = fileName + file.getOriginalFilename();
			File uploadFile = new File(saveFolder,fileName);
			try {
				file.transferTo(uploadFile);  //파일 저장하기
			}catch(Exception e) {
				e.printStackTrace();
			}
			vo.setNoticeFile(file.getOriginalFilename());  //원본 파일명
			vo.setNoticeFileDir(fileName); //물리적 파일 저장위치
		}
		
		noticeService.noticeInsert(vo);  //db 저장
		return "redirect:noticeList.do";
	}
	
	@PostMapping("/noticeUpdate.do")
	public String noticeUpdate(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeService.noticeSelect(vo));
		return "notice/noticeUpdate";
	}
	
	@PostMapping("/noticeDelete.do")
	public String noticeDelete(NoticeVO vo, Model model) {
		int n = noticeService.noticeDelete(vo);
		if(n != 0) {
			model.addAttribute("message", "정상적으로 삭제 되었습니다.");
		}else {
			model.addAttribute("message", "삭제가 정상적으로 처리되지 않았습니다.");
		}
		return "notice/noticeMessage";
	}
	
	@PostMapping("/noticeEdit.do")
	public ModelAndView noticeEdit(NoticeVO vo, ModelAndView mv, MultipartFile file) {  //ModelAndView 객체 사용시
		String saveFolder = servletContext.getRealPath("/resources/upload/"); //파일저장위치 가져오기
		if(!file.isEmpty()) {  //첨부파일이 존재하면
			String fileName = UUID.randomUUID().toString();
			fileName = fileName + file.getOriginalFilename();
			File uploadFile = new File(saveFolder,fileName);
			try {
				file.transferTo(uploadFile);  //파일 저장하기
			}catch(Exception e) {
				e.printStackTrace();
			}
			vo.setNoticeFile(file.getOriginalFilename());  //원본 파일명
			vo.setNoticeFileDir(fileName); //물리적 파일 저장위치
		}
		int n = noticeService.noticeUpdate(vo); 
		if(n != 0) {
			mv.addObject("notice", noticeService.noticeSelect(vo));
			mv.setViewName("notice/noticeSelect");
		}else {
			mv.addObject("message", "수정이 정상적으로 처리되지 못했습니다.");
			mv.setViewName("notice/noticeMessage");
		}	
		return mv;
	}
/*	
	@PostMapping("/noticeEdit.do")
	public String noticeEdit(NoticeVO vo, Model model) {
		String viewPage = null;
		int n = noticeService.noticeUpdate(vo); 
		if(n != 0) {
			model.addAttribute("notice", noticeService.noticeSelect(vo));
			viewPage = "notice/noticeSelect";
		}else {
			model.addAttribute("message", "수정이 정상적으로 처리되지 못했습니다.");
			viewPage = "notice/noticeMessage";
		}	
		return viewPage;
	}
*/
}
