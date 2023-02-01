package co.yedam.exam.notice.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")  //jackson json객체시 날짜 포맷설정
	private Date noticeDate;
	private String noticeTitle;
	private String noticeSubject;
	private int noticeHit;
	private String noticeFile;
	private String noticeFileDir;
	
	//Search
	private String key;
	private String val;
}
