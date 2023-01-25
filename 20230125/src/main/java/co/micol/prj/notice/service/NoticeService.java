package co.micol.prj.notice.service;

import java.util.List;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeList();		//전체목록
	NoticeVO noticeSelect(NoticeVO vo);	//데이터 한개보기
	
	int noticeInsert(NoticeVO vo);		//추가
	int noticeUpdate(NoticeVO vo);		//수정
	int noticeDelete(NoticeVO vo);		//삭제
	
	List<NoticeVO> noticeSearch(String key, String val);	//검색
}
