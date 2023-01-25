package co.micol.prj.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.micol.prj.notice.map.NoticeMapper;
import co.micol.prj.notice.vo.NoticeVO;

@Service	//나는 서비스야
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired	//자동으로 주입해서 넣어주세여
	NoticeMapper noticeMapper;
	
	@Override
	public List<NoticeVO> noticeList() {
		return noticeMapper.noticeList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
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
