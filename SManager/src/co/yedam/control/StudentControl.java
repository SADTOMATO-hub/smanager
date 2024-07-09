package co.yedam.control;

import java.util.List;
import java.util.Scanner;
import co.yedam.dao.StudentDAO;
import co.yedam.vo.StudentVo;

/*
 *사용자입력을 가이드, 처리된 결과 출력 
 * */
public class StudentControl {
	Scanner sc= new Scanner(System.in);
	StudentDAO sdao = new StudentDAO();
	
	
	public void run() {
		boolean isTrue = true;
		
		while(isTrue) {
			System.out.println("1.학생목록 2.등록 3.수정 4.삭제 5.종료");
			System.out.print("선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu){
			case 1:
				studentList();
				break;
			case 2:
				add();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("종료");
				isTrue = false;
			}//switch
		}//while
	}//run()
	//등록기능
	void add() {
		System.out.print("이름 > ");
		String dream = sc.nextLine();
		System.out.print("전화번호  > ");
		String hope = sc.nextLine();
		System.out.print("주소  > ");
		String hell = sc.nextLine();
		System.out.print("날짜  > ");
		String heaven = sc.nextLine();
		System.out.print("학번  > ");
		String choco = sc.nextLine();
		StudentVo student = new StudentVo();
		student.setStudentName(dream);
		student.setStudentPhone(hope);
		student.setAddress(hell);
		student.setBirthDate(heaven);
		student.setStudentNo(choco);
		
		if(sdao.insertStudent(student)) {
			System.out.println("저장완료");
		}else {
			System.out.println("오류발생");
		}
	}
	
	//목록 출력 기능
	void studentList() {
		List<StudentVo> students =  sdao.selectList();
		System.out.println("학생번호     학생이름   연락처");
		System.out.println("=========================");
		for(StudentVo svo : students) {
			System.out.println(svo.briefShow());
		}
	}//studentList()
}//class
