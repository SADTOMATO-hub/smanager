package com.yedam.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVO;

public interface StudentMapper {
	//목록반환
	List<StudentVO> studentList();
	StudentVO selectOne(String sno);
	int insertStudent(StudentVO svo);
	//맴버 반환
	List<MemberVO> memberList();
	//로그인체크.
	MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	
}
