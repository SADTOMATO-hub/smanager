package com.yedam.common;

import org.apache.ibatis.session.SqlSession;

import com.yedam.Service.ReplyService;
import com.yedam.Service.ReplyServiceImpl;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);// 커밋
		ReplyService svc = new ReplyServiceImpl();
		
		ReplyVO rvo = new ReplyVO();
		rvo.setReplyContent("love");
		rvo.setReplyer("user01");
		rvo.setBoardNo(148);
		
		if(svc.removeReply(2)) {
			System.out.println("처리완료");
		}else {
			System.out.println("처리실패");
		}
		
		
		svc.replyList(148).forEach(System.out::println);

	}
}
