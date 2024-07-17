package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.StudentMapper;
import com.yedam.vo.StudentVO;

/**
 * Servlet implementation class StudentServe
 */
@WebServlet("/StudentAddServ")
public class StudentAddServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAddServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sno=S2024-11&sname=박기역&sphone=010-1111-2222&sbirth=1996-11-29
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String sphone = request.getParameter("sphone");
		String sbirth = request.getParameter("sbirth");
		StudentVO svo = new StudentVO();
		svo.setStudentNo(sno);
		svo.setStudentName(sname);
		svo.setStudentPhone(sphone);
		svo.setBirthDate(sbirth);
		
		SqlSession sqlSession =DataSource.getInstance().openSession(true);
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		mapper.insertStudent(svo);
		
		response.sendRedirect("SampleServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
