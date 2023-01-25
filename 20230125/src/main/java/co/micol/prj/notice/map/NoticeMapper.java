package co.micol.prj.notice.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeList();
	NoticeVO noticeSelect(NoticeVO vo);	
	
	int noticeInsert(NoticeVO vo);	
	int noticeUpdate(NoticeVO vo);		
	int noticeDelete(NoticeVO vo);		
	
	List<NoticeVO> noticeSearch(@Param ("key") String key, @Param("val") String val);	
	//전달되는 매개변수가 2개이상일때 파라메타를 붙여줘야한다.
	//key라는게 넘어오면 key, val이라는게 넘어오면 val
}
