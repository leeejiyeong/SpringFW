package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	//전체조회
	List<MemberVO> memberListSelect();
	//한명 조회
	MemberVO memberSelect(MemberVO vo);
	
	//한명 추가
	int memberInsert(MemberVO vo);
	//수정
	int memberUpdate(MemberVO vo);
	//삭제
	int memberDelete(MemberVO vo);
	
	//아이디 중복체크
	boolean isIdCheck(String id);
	
}
