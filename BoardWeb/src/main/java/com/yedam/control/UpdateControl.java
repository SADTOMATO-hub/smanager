package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.BoardService;
import com.yedam.Service.BoardServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.BoardVO;

public class UpdateControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardService svc = new BoardServiceImpl();
		
		BoardVO board = new BoardVO();
		
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		board.setTitle(title);
		board.setContent(content);
		board.setBoardNo(Integer.parseInt(bno));
		
		if(svc.modifyBoard(board)){
			//목록으로 이동
			resp.sendRedirect("boardList.do");
		}else {
			resp.sendRedirect("modifyBoard.do?bno" + bno);
		}
	}

}
