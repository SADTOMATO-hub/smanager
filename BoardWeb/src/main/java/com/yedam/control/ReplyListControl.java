package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.Service.ReplyService;
import com.yedam.Service.ReplyServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		String bno =req.getParameter("bno");
		
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.selectList(Integer.parseInt(bno));
		
		Map<String, Object> map = new HashMap<>();
		map.put("data", list);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		json = gson.toJson(map); // datatable연습.
		
		resp.getWriter().print(json);

	}

}
