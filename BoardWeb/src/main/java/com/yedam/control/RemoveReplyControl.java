package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.ReplyService;
import com.yedam.Service.ReplyServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.ReplyVO;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String replyNo = req.getParameter("rno");
		String bno = req.getParameter("bno");
		ReplyService rsv = new ReplyServiceImpl();
	//	rsv.removeReply(Integer.parseInt(replyNo));
		
		if(rsv.removeReply(Integer.parseInt(replyNo))) {
			//성공적으로 삭제가 되면...{"retCode" : "Success"}
			resp.getWriter().print("{\"retCode\" : \"Success\"}");
		}else {
			//삭제가 실패되면 ...{"retCode" : "Fail"}
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}
	}

}
