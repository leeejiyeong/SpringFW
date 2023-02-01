package co.yedam.exam.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.exam.notice.map.NoticeMapper;
import co.yedam.exam.notice.vo.NoticeVO;
@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired NoticeMapper noticeMapper;
	
	@Override
	public List<NoticeVO> noticeList() {
		return noticeMapper.noticeList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		System.out.println("상세보기");
		return noticeMapper.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return noticeMapper.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return noticeMapper.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return noticeMapper.noticeDelete(vo);
	}

	@Override
	public List<NoticeVO> noticeSearch(String key, String val) {
		return noticeMapper.noticeSearch(key, val);
	}

}
