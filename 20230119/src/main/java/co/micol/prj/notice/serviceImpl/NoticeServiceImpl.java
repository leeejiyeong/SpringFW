package co.micol.prj.notice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.micol.prj.notice.map.NoticeMapper;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Service	//나는 서비스에요 
public class NoticeServiceImpl implements NoticeService {	//noticeService를 통해서 noticeServiceImple을 만들건데
	
	@Autowired
	private NoticeMapper noticeMapper;	//noticeMapper연결해서 mybatis, DataSource 자동주입. 이름을 맞춰주는게 좋다
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		
		return noticeMapper.noticeSelectList();
	}
	
	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return noticeMapper.noticeSelect(vo);
	}

}
