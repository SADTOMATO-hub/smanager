package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.ReplyService;
import com.yedam.Service.ReplyServiceImpl;
import com.yedam.common.Control;

public class paginCountControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//글번호에 따른 댓글건수를 반영
		String bno = req.getParameter("bno");
		
		ReplyService svc = new ReplyServiceImpl();
		int totalCnt = svc.replyTotalCnt(Integer.parseInt(bno));
		
		// {"totalCnt" : 30} 형태로 
		resp.getWriter().print("{\"totalCnt\" : " +totalCnt+"}");
		
	}

}
