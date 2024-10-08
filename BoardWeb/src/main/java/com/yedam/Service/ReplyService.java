package com.yedam.Service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	//datatable
	List<ReplyVO> selectList(int boardNo);
	boolean addReply(ReplyVO rvo);
	boolean removeReply(int replyNo);
	
	int replyTotalCnt(int boardNo); //댓글갯수
}
