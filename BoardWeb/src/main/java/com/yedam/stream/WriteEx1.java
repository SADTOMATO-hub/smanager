package com.yedam.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteEx1 {	
	public static void main(String[] args) {
		//기본스트림 - 보조스트림 - 추가적인 기능 수행.
		List<MemberVO> members = new ArrayList<>();
		try {
			FileReader fr = new FileReader("c:/temp/file3.dat");
			BufferedReader/*한 라인 씩 읽는 기능이 있음*/ br = new BufferedReader(fr);
			String str = "";
			String[] strAry = null;
			while(true) {
				str = br.readLine(); //한 라인 읽기. 101 홍길동 90
				if(str == null) {
					break;					
				}//while				
				//파일의 정보를 활용 -> 컬렉션 생성
				MemberVO mvo = new MemberVO();
				strAry = str.split(" "); // 공란을 기준으로 분류
				mvo.setMemberNo(Integer.parseInt(strAry[0]));
				mvo.setMemberName(strAry[1]);
				mvo.setPoint(Integer.parseInt(strAry[2]));
				members.add(mvo);
				
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		members.forEach(System.out::println);
		System.out.println("complete");
	}//main		
	static void reader1() {
		// Reader <- FileReader
		try {
			Reader reader = new FileReader("c:/temp/file2.dat");
			while(true) {
				int read = reader.read();
				if (read == -1)
					break;
				System.out.println(read + " - > " + (char)read); // byte char short int long
			}
			reader.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("complete");		
	}// reader1
	static void write1() {
		// 문자기반 스트림 Writer <- FileWriter
		Scanner sc = new Scanner(System.in);
		try {
			Writer writer = new FileWriter("c:/temp/file2.dat");
			while(true) {
				System.out.println("입력 >> ");
				String str = sc.nextLine();
				if(str.equals("quit")) 
					break;
				
				writer.write(str + '\n');
			}
			writer.flush();
			writer.close();
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("complete");
	}//write 1
}//class
