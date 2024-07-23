package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.MemberService;
import com.yedam.Service.MemberServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MemberService memList = new MemberServiceImpl();
		List<MemberVO> memLi = memList.memberList(); 
		
		req.setAttribute("memberList", memLi);
		
		req.getRequestDispatcher("admin/memberList.tiles")//
		.forward(req, resp); // 페이지 재지정.
	}

}
