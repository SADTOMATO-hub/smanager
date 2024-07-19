package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	private int page; //현재 페이지
	private int startpage, endpage; // << 1 2 3 4 5 6 7 8 9 10 
	private boolean prev, next;
	
	public PageDTO(int page, int totalCnt) {
		// Ex) page: 13, totalCnt: 88 (18page)
		this.page = page;
		this.endpage = (int) (Math.ceil(page / 10.0) * 10);  // 2*10
		this.startpage = this.endpage - 9; //
		
		int realEnd = (int) Math.ceil( totalCnt / 5.0); // 실제건수 계산한 마지막 페이지
		this.endpage = this.endpage > realEnd ? realEnd : this.endpage;
		
		this.prev = this.startpage > 1;
		this.next = this.endpage < realEnd;
	}
}//end class
