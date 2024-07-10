package co.yedam.control;

import java.util.List;
import java.util.Scanner;
import co.yedam.dao.StudentDAO;
import co.yedam.vo.StudentVo;

/*
 *사용자입력을 가이드, 처리된 결과 출력 
 * */
public class StudentControl {
	Scanner sc = new Scanner(System.in);
	StudentDAO sdao = new StudentDAO();

	public void run() {
		boolean isTrue = true;

		while (isTrue) {
			System.out.println("1.학생목록 2.등록 3.수정 4.삭제 5.종료");
			System.out.print("선택 > ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				studentList();
				break;
			case 2:
				add();
				break;
			case 3:
				moidfyStudent();
				break;
			case 4:
				deleteInfo();
				break;
			case 5:
				System.out.println("종료");
				isTrue = false;
			}// switch
		} // while
	}// run()
		// 삭제기능

	void deleteInfo() {
		System.out.print("삭제하려는 학생의 학번을 입력하세요 > ");
		String sNum = sc.nextLine();
		while (true) {
			if (sdao.selectExists(sNum) == 1) {
				// 학생번호가 존재한다면
				break;
			} else {
				System.out.println("입력하신 학생 정보가 존재하지 않습니다.");
				return;
			}
		}
		System.out.println("정말로 삭제하시겠습니까?");
		System.out.print("삭제하겠습니다.를 입력해주세요. > ");
		String check = "삭제하겠습니다.";
		String check2 = "삭제 하겠습니다.";
		String check3 = "삭제하겠습니다";
		String check4 = "삭제 하겠습니다";

		String choice = sc.nextLine();
		
		while (true) {
			if (choice.equals(check) || choice.equals(check2) || choice.equals(check3) || choice.equals(check4)) {
				StudentDAO std = new StudentDAO();
				std.deleteStudent(sNum);
				System.out.println("삭제했습니다.");
				break;
			} else {
				System.out.println("확인 문장을 정확하게 입력해주세요");
				return;
			}
		}

	}// deleteInfo

	// 수정기능
	void moidfyStudent() {
		int count = 0;
		String sNum = "";
		while (true) {
			System.out.print("변경할 학생의 학번을 입력해주세요 > ");
			sNum = sc.nextLine();
			if (sdao.selectExists(sNum) == 1) {
				// 학생번호가 존재한다면
				break;
			} else {
				++count;
				System.out.print("학생번호가 존재하지 않습니다 \n");
				if (count == 3) {
					System.out.println("3번 입력 실패했습니다. 처음으로 돌아가겠습니다");
					return;
				}
			}
		} // while
		System.out.print("변경할 학생의 이름을 입력해주세요 > ");
		String sName = sc.nextLine();
		System.out.print("변경할 학생의 연락처를 입력해주세요 > ");
		String hpNum = sc.nextLine();
		System.out.print("변경할 학생의 주소를 입력해주세요 > ");
		String address = sc.nextLine();
		System.out.print("변경할 학생의 생일을 입력해주세여 > ");
		String bDate = sc.nextLine();
		StudentVo std = new StudentVo();
		std.setStudentName(sName);
		std.setStudentPhone(hpNum);
		std.setAddress(address);
		std.setBirthDate(bDate);

		if (sdao.updateStudent(std)) {
			System.out.println("수정완료");
		} else {
			System.out.println("오류발생");
		}
	};

	// 등록기능
	void add() {
		System.out.print("이름 > ");
		String name = sc.nextLine();
		System.out.print("전화번호  > ");
		String hpNum = sc.nextLine();
		System.out.print("주소  > ");
		String address = sc.nextLine();
		System.out.print("날짜  > ");
		String bDate = sc.nextLine();
		System.out.print("학번  > ");
		String sNum = sc.nextLine();
		StudentVo student = new StudentVo();
		student.setStudentName(name);
		student.setStudentPhone(hpNum);
		student.setAddress(address);
		student.setBirthDate(bDate);
		student.setStudentNo(sNum);

		if (sdao.insertStudent(student)) {
			System.out.println("저장완료");
		} else {
			System.out.println("오류발생");
		}
	}

	// 목록 출력 기능
	void studentList() {
		List<StudentVo> students = sdao.selectList();
		System.out.println("학생번호     학생이름   연락처");
		System.out.println("=========================");
		for (StudentVo svo : students) {
			System.out.println(svo.briefShow());
		}
	}// studentList()
}// class
