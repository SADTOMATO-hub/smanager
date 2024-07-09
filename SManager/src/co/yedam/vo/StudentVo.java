package co.yedam.vo;

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

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "StudentVo [studentNo=" + studentNo + ", studentName=" + studentName + ", studentPhone=" + studentPhone
				+ ", address=" + address + ", birthDate=" + birthDate + "]";
	}
	
	public String briefShow() {
		return studentNo + " " +  studentName + "  "  +   studentPhone;
	}

}
