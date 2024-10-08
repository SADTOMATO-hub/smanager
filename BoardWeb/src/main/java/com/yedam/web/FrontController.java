package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.ActionControll;
import com.yedam.control.AddBoardControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.AddStudent;
import com.yedam.control.Board;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardForm;
import com.yedam.control.BoardListControl;
import com.yedam.control.CntByMember;
import com.yedam.control.DeleteFormControl;
import com.yedam.control.GoogleChart;
import com.yedam.control.ImageDownLoad;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginForm;
import com.yedam.control.LogoutControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyForm;
import com.yedam.control.RemoveForm;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.RemoveStudent;
import com.yedam.control.ReplyListControl;
import com.yedam.control.ScriptContol;
import com.yedam.control.StudentJson;
import com.yedam.control.StudentListControl;
import com.yedam.control.UpdateControl;
import com.yedam.control.paginCountControl;

/*
 * FrontController 역할은 사용자의 모든 요청을 처리
 * FrontController 역할은 서블릿의 기능을 하지 않게 하려고, 그 기능을 Control로 대체
 * 서블릿. a.d, sample.do
 * 객체생성 -> init(최초 호출 때 단 한 번 호출된다.) -> service(그후 이 친구가 계속 호출된다.  .do도 그러하다.) -> destroy. 
 */
public class FrontController extends HttpServlet {
	
	Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl());
		//글등록 구현 : 등록화면 + DB등록(addBoard.do) -> 글목록페이지이동.
		map.put("/boardForm.do", new BoardForm());
		map.put("/addBoard.do", new AddBoardControl());
		//학생목록.
		map.put("/stdList.do", new StudentListControl());
		//보드 띄우기
		map.put("/board.do", new BoardControl());
		//삭제 기능
		map.put("/removeBoard.do", new RemoveForm());
		map.put("/deleteBoard.do", new DeleteFormControl());
		//수정 기능
		map.put("/modifyBoard.do", new ModifyForm());
		map.put("/updateBoard.do", new UpdateControl());
		//태그연습
		map.put("/action.do", new ActionControll());
		//로그인 기능
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new LoginControl());
		//로그아웃 기능
		map.put("/logout.do", new LogoutControl());
		//관리자 기능
		map.put("/memberList.do", new MemberListControl());
		//자바스크립트 호출
		map.put("/javascript.do", new ScriptContol());
		//학생정보를 반환해주는 페이지(json)
		map.put("/studentJson.do", new StudentJson());
		//학생정보(학번기준) 삭제
		map.put("/removeStudent.do", new RemoveStudent());
		//학생정보 등록
		map.put("/addStudent.do", new AddStudent());
		//댓글출력
		map.put("/replyList.do", new ReplyListControl());
		//댓글등록
		map.put("/addReply.do", new AddReplyControl());
		//댓글삭제
		map.put("/removeReply.do", new RemoveReplyControl());
		//페이징을 위한 전체건수
		map.put("/paginCount.do", new paginCountControl());
		//이미지 다운로드
		map.put("/imageDownload.do", new ImageDownLoad());
		//작성자별 게시건수
		map.put("/countByMember.do", new CntByMember());
		//차트페이지
		map.put("/googleChart.do", new GoogleChart());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// boarList.do -목록. 
		//addBoard.do -등록
		String uri = req.getRequestURI();// URL(http://localhost/BoardWeb/boardList.do)
		String context = req.getContextPath(); // 프로젝트 명
		String path = uri.substring(context.length());//"/boardList.do"
		
		System.out.println(path); // /board.do
		Control sub = map.get(path);
		sub.exec(req, resp);
	}

}
