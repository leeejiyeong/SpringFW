package co.micol.prj.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	//autowired안하면 memberService memberservice = new memberservice() 이래 써야됨
	
	@RequestMapping("/memberListSelect.do")
	public String memberListSelect(Model model) {
		model.addAttribute("lists", memberService.memberListSelect());
		
		return "member/memberListSelect";
	}
	
	@PostMapping("/memberLogin.do")
	public String memberLogin(MemberVO vo, Model model, HttpSession session) {	//매개변수로 이러이러이런거 쓸거다 알려줌
		vo = memberService.memberSelect(vo);
		
		if(vo != null) {
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("author", vo.getMemberAuthor());
			session.setAttribute("name", vo.getMemberName());
			model.addAttribute("message", vo.getMemberName() + "님 환영합니다.");
		}else {
			model.addAttribute("message", "아이디 또는 패스워드가 틀립니다.");
		}
		
		return "member/memberMessage";		//로그인 성공했을때 보여질 페이지 경로
	}
	
	@RequestMapping("/memberLoginForm.do")
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}
	
	@RequestMapping("/memberLogout.do")
	public String memberLogout(Model model, HttpSession session) { 	//httpsession만 있으면됨(?)
		model.addAttribute("message", session.getAttribute("name") + "님 정상적으로 로그아웃 되었습니다.");
		session.invalidate();
		
		return "member/memberMessage";
	}
	
	@RequestMapping("/memberJoinForm.do")
	public String memberJoinForm() {
		return "member/memberJoinForm";
	}
	
	@PostMapping("/memberJoin.do")
	public String memberJoin(MemberVO vo) {
		return "redirect:memberListSeclect.do";
		//redirect: 원래 viewResolve로 가야되는데 view로 안가고 다시 컨트롤러로 돌려보냄
	}
}
