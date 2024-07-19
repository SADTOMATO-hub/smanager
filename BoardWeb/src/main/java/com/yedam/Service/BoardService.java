package com.yedam.Service;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

/*
 * MVC 패턴의 디자인에 따라서 model영역(service-업무로직 관리, dao:mapper)
 * 책 : 4강 MVC기반 웹프로젝트 참고.
 * 숙제: 536페이지 MVC에 대해 자세히 읽기.
 */
public interface BoardService {
	List<BoardVO> boardList(SearchDTO search);
	int totalCount(SearchDTO search); // 페이징 계산용 건수
	boolean addBoard(BoardVO board);
	boolean modifyBoard(BoardVO board);
	boolean removeBoard(int board);
	BoardVO getBoard(int boardNo);
}
