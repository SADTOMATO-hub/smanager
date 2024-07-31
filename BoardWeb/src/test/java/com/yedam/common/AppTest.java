package com.yedam.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yedam.Service.MemberService;
import com.yedam.Service.MemberServiceImpl;

public class AppTest {
	public static void main(String[] args) {
		MemberService svc = new MemberServiceImpl();
		List<Map<String, Object>> list = svc.getCountByMember();
		for(Map<String, Object> map : list) {
			System.out.println("--------------------");
			Set<String> keyset = map.keySet();
			for(String key : keyset) {
				System.out.println(key + ", " + map.get(key/*밸류*/));
			}
		}
		System.out.println("완");
	}
}
