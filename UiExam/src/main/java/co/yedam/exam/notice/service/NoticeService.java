package co.yedam.exam.notice.service;

import java.util.List;

import co.yedam.exam.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	List<NoticeVO> noticeSearch(String key, String val);
}
