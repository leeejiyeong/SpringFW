package co.micol.prj.notice.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")	//jackson json데이터를 불러올때 날짜 포멧을 맞춰준다
	private Date noticeDate;
	
	private String noticeTitle;
	private String noticeSubject;
	private int noticeHit;
	private String noticeFile;
	private String noticeFileDir;
}
