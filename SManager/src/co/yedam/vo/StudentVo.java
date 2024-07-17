package co.yedam.vo;

import lombok.Data;

@Data
public class StudentVo {
	// 필드
	private String studentNo; // student_no
	private String studentName;// student_name
	private String studentPhone; // student_phone
	private String address; // address
	private String birthDate; // birth_date
	// 생성자
	// 기본 생성자
	// 메서드

	public String briefShow() {
		return studentNo + " " + studentName + "  " + studentPhone;
	}

}
