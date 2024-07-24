package com.yedam.common;

import org.apache.ibatis.session.SqlSession;

import com.yedam.mapper.StudentMapper;

public class AppTest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);// 커밋
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		mapper.memberList("Admin", "member_pw").forEach(System.out::println);

	}
}
