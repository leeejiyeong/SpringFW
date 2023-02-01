package co.yedam.exam.shop.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeVO {
	private String shEmpId;
	private String shEmpName;
	private String shEmpDpt;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date shEmpStartDate;
	private Date shEmpEndDate;
	private String shEmpRank;
}
