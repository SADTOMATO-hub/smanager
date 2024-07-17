package co.yedam.dao;
/*DB connection 기능.*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	Connection conn = null;
	Statement stmt;
	ResultSet re;

	public Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "teacher";
		String password = "teacher";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);// db에 접속하는 역할
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("오라클 드라이버 없음.");
			e.printStackTrace();
		}
		return conn;
	}// getConn
}// class
