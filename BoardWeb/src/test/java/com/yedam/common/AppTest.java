package com.yedam.common;

import com.yedam.Service.BoardService;
import com.yedam.Service.BoardServiceImpl;

public class AppTest {
	public static void main(String[] args) {
//		SqlSession sqlSession = 
//				DataSource.getInstance().openSession(true);//커밋
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
//		
//		System.out.println("START");
//
		BoardService svc = new BoardServiceImpl();
//		svc.boardList(9).forEach(System.out::println);
//		System.out.println("끝");
		
		SearchDTO search = new SearchDTO();
		search.setPage(10);
		search.setSearchCondition("TW");
		search.setKeyword("aaa");
		
		svc.boardList(search).forEach(System.out::println);
		
//		BoardVO brd = new BoardVO();
//		brd.setTitle("매퍼테스트");
//		brd.setContent("조건이 진행되는가");
//		brd.setWriter("newbie");
//		brd.setBoardNo(5);
//		brd.setBoardNo(0);
//		mapper.deleteBoard(21);
//		
//		
//		if(mapper.deleteBoard(22)==1) {
//			System.out.println("성공적으로 삭제했습니다.");
//		};
		
		
//		if(mapper.insertBoard(brd)==1){
//			System.out.println("ok");
//		}
		
//		mapper.selectList()//
//				.forEach(board -> System.out.println(board.toString()));
		
//		BoardVO scv  = mapper.selectBoard(3);
		
		
//		System.out.println(scv.getBoardNo());
		
		
	}
}
