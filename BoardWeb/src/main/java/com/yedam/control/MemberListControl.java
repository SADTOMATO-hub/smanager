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
	public void exec(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {
		
		String res = req.getParameter("res");
		String order = req.getParameter("order");
		res = res == null ? "Admin" : res;
		order = order == null ? "member_id" : order;
		
		MemberService memList = new MemberServiceImpl();
		List<MemberVO> memLi = memList.memberList(res, order); 
		
		req.setAttribute("memberList", memLi);
		
		req.getRequestDispatcher("admin/memberList.tiles")//
		.forward(req, resp); // 페이지 재지정.
	}

}
