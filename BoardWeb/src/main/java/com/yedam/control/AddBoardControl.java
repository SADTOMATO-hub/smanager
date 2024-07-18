package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.Service.BoardService;
import com.yedam.Service.BoardServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		String title = req.getParameter("title");
		
		BoardVO bv = new BoardVO();
		bv.setWriter(writer);
		bv.setContent(content);
		bv.setTitle(title);
		
		BoardService svc = new BoardServiceImpl();
		if(svc.addBoard(bv)) {
			//목록이동.
			resp.sendRedirect("boardList.do");
		}
	}
	
}//end class
