package co.yedam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.StudentMapper;

import co.yedam.mapper.DataSource;
import co.yedam.vo.StudentVo;

public class MybatisTest {
	public static void main(String[] args) {
		SqlSessionFactory F = DataSource.getInstance();
		SqlSession SqlSession = F.openSession(true);// DataBase와 연결해주는 역할, true = 자동커밋
		// 매퍼인터페이스의 구현 => 구현클래스
		StudentMapper mapper = SqlSession.getMapper(StudentMapper.class);
		StudentVo svo = new StudentVo();
//		svo.setStudentNo("S2024-07");
//		svo.setStudentName("김똘똘");
//		svo.setStudentPhone("010-9339-2771");

//		int cnt = mapper.insertStudent(svo);
//		System.out.println("처리된 건수 : " + cnt);

//		svo.setStudentPhone("010-변경된 번호");
//		svo.setStudentName("김정민");

		svo.setStudentNo("s2016-04");

		int cnt = mapper.deleteStudent(svo);

//		int cnt2 = mapper.updateStudent(svo2);

		System.out.println("처리된 건수 : " + cnt);

		// 목록 부르기
		List<StudentVo> list = mapper.studentList();
		for (StudentVo love : list) {
			System.out.println(love);
		}
		System.out.println("OK");
	}
}
