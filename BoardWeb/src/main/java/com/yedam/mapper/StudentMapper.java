package com.yedam.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVO;

public interface StudentMapper {
	//목록반환
	List<StudentVO> studentList();
	StudentVO selectOne(String sno);
	int insertStudent(StudentVO svo);
	int deleteStudent(String studentNo);
	//맴버 반환
	List<MemberVO> memberList(@Param("res") String res, @Param("order") String order);
	//로그인체크.
	MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	//작성자별 건수 반영
	List<Map<String/*컬럼 이름*/, Object/*건수*/>> selectCountMember();
}
