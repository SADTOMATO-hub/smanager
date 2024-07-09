package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import co.yedam.vo.StudentVo;

public class AppTests {
	public static Connection getConn() {
		String url = "jdbc:oracle:thin:@192.168.0.28:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "jsp";
		String password = "jsp";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);// db에 접속하는 역할
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("오라클 드라이버 없음.");
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	public static void main(String[] args) {
		// 1) Oracle JDBC Driver 자바라이브러리
		// 2) Connection 객체.
		Scanner sc = new Scanner(System.in);
//		System.out.print("학생 번호를 입력하시오 > ");  //sql에서 학번을 프라이머리 키로 입력했기 때문에 중복된 정보를 입력하면 오류가 발생함.
//		String Snum = sc.nextLine();
//		System.out.print("학생 이름을 입력하시오 > ");
//		String name = sc.nextLine();
//		System.out.print("학생 전번을 입력하시오 > ");
//		String phone = sc.nextLine();
//		System.out.print("학생 주소를 입력하시오 > ");
//		String add = sc.nextLine();
//		addStudent(Snum, name, phone, add); //입력
//		                          search(); //조회
//		System.out.print("수정할 날짜를 입력하시오 > ");
//		String date1 = sc.nextLine();
//		System.out.print("어떤 학번의 날짜를 변경하시겠습니까? > ");
//		String no1 = sc.nextLine();
//		             modStudent(date1, no1);//수정
//		System.out.print("삭제할 조건을 입력해주세요 > ");
//		String love = sc.nextLine();
//	                       	  delete(love);// 삭제
		System.out.print("이름 > ");
		String dream = sc.nextLine();
		System.out.print("번호  > ");
		String hope = sc.nextLine();
		System.out.print("주소  > ");
		String hell = sc.nextLine();
		System.out.print("날짜  > ");
		String heaven = sc.nextLine();
		System.out.print("학번  > ");
		String choco = sc.nextLine();
		StudentVo student = new StudentVo();
		modDetail(student); // 부분 수정
		student.setStudentName(dream);
		student.setStudentPhone(hope);
		student.setAddress(hell);
		student.setBirthDate(heaven);
		student.setStudentNo(choco);
		// 위의 기능들은 자동으로 커밋이 실행된다.
		
		sc.close();
	}// main

	// 삭제기능
	// delete from tbl_student
	// where student_no = 20150900;
	public static void delete(String num) {
		Connection conn = getConn();
		String sql = "delete from tbl_student ";
		sql += "where student_no =  '" + num + "' ";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 수정기능
	// update tbl_student
	// set birth_date = '19961129'
	// where student_no = 's2015-01';
	public static void modStudent(String date, String num) {
		Connection conn = getConn();
		String sql = "update tbl_student ";
		sql += "set birth_date = '" + date + "";
		sql += "'  where student_no = '" + num + "'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 부분 수정
	// update tbl_student
	// set student_name = nvl(null, student_name),
	// student_phone = nvl(null, student_phone),
	// address = nvl(null, address),
	// birth_date = nvl('2020-06-20', birth_date)
	// where student_no = '20202020';
	public static void modDetail(StudentVo svo) {
		Connection conn = getConn();
		String sql = "update tbl_student ";
		sql += "set student_name = nvl('" + svo.getStudentName() + "', student_name), ";
		sql += "student_phone = nvl('" + svo.getStudentPhone() + "', student_phone), ";
		sql += "address = nvl('" + svo.getAddress() + "', address), ";
		sql += "birth_date = nvl('" + svo.getBirthDate() + "', birth_date) ";
		sql += "where student_no = '" + svo.getStudentNo() + "'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 입력기능.
	// INSERT into tbl_student (student_no, student_name, student_phone, address)
	// values ('s2016-04', '김정민', '010-5779-2126', '서울')
	public static void addStudent(String num, String name, String phoe, String adress) {// 매개변수를 통해 입력 자율성 상승
		Connection conn = getConn();
		String sql = "INSERT into tbl_student (student_no, student_name, student_phone, address)";
		sql += "values ('" + num + "', '" + name + "', '" + phoe + "', '" + adress
				+ "')";/* primary키가 중복되지 않게끔 조심하십시오 휴먼 */
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete => 처리된 건수
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 조회를 처리하는 기능
	public static void search() {
		// 조회기능
		try {
			Connection conn = getConn();
			Statement stmt = conn.createStatement(); // sql에 import하시오
			ResultSet rs = stmt.executeQuery("select *from tbl_student");/* ;필요 없음 */
			// [객체1, 객체2, 객체3] 커넥션에 처리된 값을 가지고 있음
			while (rs.next()) { // 위의 객체 순번대로 돎, 객체3이후로는 데이터가 없으니 false가 입력됨
				System.out.println(rs.getString("student_no") + ", " + rs.getString("student_name") + ", "
						+ rs.getString("student_phone") + ", " + rs.getString("birth_date"));
			}
			System.out.println("end of data");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 조회기능 끝.
	}
}// class
