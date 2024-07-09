package co.yedam.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.vo.StudentVo;


/*
 * 목록(R), 등록(C), 수정(U), 삭제(D)
 * 주의: DAO 메세지가 없음. ex)sysout
 * 반환값과 매개값을 이용해야함
 */
public class StudentDAO extends DAO{
	List<StudentVo> list = new ArrayList<>(); 
	PreparedStatement psmt;
	//등록기능
	public boolean insertStudent(StudentVo svo) {
			String sql = "insert into tbl_student (student_no, student_name, student_phone, address)";
			sql += "values(?, ?, ?, ?)";
			conn = getConn();
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, svo.getStudentNo());
				psmt.setString(2, svo.getStudentName());
				psmt.setString(3, svo.getStudentPhone());
				psmt.setString(4, svo.getAddress());
				
				int r = psmt.executeUpdate();
				if(r==1) {
					return true;//정상 처리
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false; //비정상 처리
	}
	
	//반환기능
	public List<StudentVo> selectList(){
		String sql = "select * from tbl_student order by student_no";
		
		conn = getConn();
		try {
			stmt = conn.createStatement();
			re = stmt.executeQuery(sql);
			while(re.next()) {
				StudentVo svo = new StudentVo();
				svo.setStudentNo(re.getString("student_no"));
				svo.setStudentName(re.getString("student_Name"));
				svo.setStudentPhone(re.getString("student_Phone"));
				svo.setAddress(re.getString("address"));
				svo.setBirthDate(re.getString("birth_Date"));
				list.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
