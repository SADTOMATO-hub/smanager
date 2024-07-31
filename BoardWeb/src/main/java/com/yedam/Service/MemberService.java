package com.yedam.Service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVO;

public interface MemberService {
	MemberVO loginCheck(String id, String pw);
	List<MemberVO> memberList(String res, String order);
	
	//학생목록을 가지고는 메서드
	List<StudentVO> studentList();
	boolean removeStudent(String sno);
	boolean addStudent(StudentVO svo);
	//차트용 작성자별 건수
	List<Map<String, Object>> getCountByMember();
}
