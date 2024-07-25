package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.MemberService;
import com.yedam.Service.MemberServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.StudentVO;

public class StudentJson implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 학생목록을 json문자열로 표현. [{"studentNo" : "s2024-001", "studentName : "홍길동"" ...},{},{}]
		resp.setContentType("text/json;charset=utf-8");
		String json = ""; //json문자열을 담기 위한
		MemberService svc = new MemberServiceImpl();
		List<StudentVO> list = svc.studentList();
		json += "[";
		for(int i = 0; i < list.size(); i++) {
			json += "{\"studentNo\":\""+list.get(i).getStudentNo()//
					+"\",\"studentName\":\""+list.get(i).getStudentName()//
					+"\",\"studentPhone\":\""+list.get(i).getStudentPhone()//
					+"\",\"studentBirth\":\""+list.get(i).getBirthDate()//
					+"\"}";
			if(i !=list.size()-1) {
				json += ",";
			}
		}
		json += "]";
		resp.getWriter().print(json);
		
	}//exec

}//class
