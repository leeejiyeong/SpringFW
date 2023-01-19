package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

import org.springframework.ui.Model;

@Controller
//여기다가 notice와 관련된건 다적으면 되는것
public class NoticeController {
	
	/* 전에는 NoticeService dao = new NoticeServiceImpl(); 이렇게 썼던걸
	 * 자동주입을 사용함으로써 아래와 같이 쓰게됨*/
	@Autowired									//한줄만 적용되기때문에 줄 바뀌면 @Autowired또 적어줘야함
	private NoticeService noticeService;		//관례적으로 변수명을 같은걸로 쓴다.
	
	/* //@GetMapping("/noticeList.do")			//cf) 홈컨트롤러에서 POST방식으로 넘겼기 때문에 GetMapping으로는 받을수가 없다.
	 * //나는 잘 모르겠다 하면 그냥 RequestMapping쓰면 된다.(get, post둘다 받기때문)근데 권장하진 않는다. 안전하지 않은 코드이기 때문.*/
	
	@RequestMapping("/noticeList.do")			//홈에서 noticeList.do로 들어오면
	public String noticeList(Model model) { 	//처리할 메소드명을 적어준다. Model:전달할 것을 담을 객체
		
		model.addAttribute("list", noticeService.noticeSelectList());
		model.addAttribute("message", "이것은 리스트를 테스트 합니다아"); 	//변수에다가 jsp에서 적은 거 적고 나타낼 내용 적어줌
		
		return "notice/noticeList";				//noticeList에 담김 내용이 model 변수에 전달된다.
	}
	
	@RequestMapping("/noticeSelect.do")
	public String noticeSelect(NoticeVO vo, Model model) {	//매개변수로 NoticeVO vo를 넣어주면 알아서 받아온다
		//여기다가 수행할 명령을 적으면된다.
		
		/* //기존의 방법
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(9);
		vo = noticeService.noticeSelect(vo);
		model.addAttribute("vo", vo);
		*/
		
		// 새로운방법
		model.addAttribute("vo", noticeService.noticeSelect(vo));
		
		return "notice/noticeSelect";
	}
}
