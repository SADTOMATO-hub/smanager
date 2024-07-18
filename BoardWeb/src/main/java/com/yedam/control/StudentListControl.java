package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class StudentListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("학생목록 출력");
		// stdList.do -> 보여줄 페이지는 WEB-INF/JSP/studentList.jsp
		try {
			req.getRequestDispatcher("WEB-INF/JSP/studentList.jsp")//
										.forward(req, resp); //페이지 재지정.
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
