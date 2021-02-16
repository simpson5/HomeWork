package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Service, Dao 클래스의 공통부문을 static 메소드 제공
 * 예외처리를 공통부분에서 작성하므로, 사용(호출)하는 쪽의 코드를 간결히 할 수 있다.
 *
 */
public class JDBCTemplate {
	private static String driverCalss = "oracle.jdbc.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	private static String url = "jdbc:oracle:thin:@khmclass.iptime.org:1521:xe";
	private static String user = "student";
	private static String password = "student";
	
	// static 초기화 블럭 = 프로그램 시작시(클래스가 처음 사용될때) 최초 1회만 실행 된다.
	static {
		try {
			//1. DriverClass등록 (최초 1회)
			Class.forName(driverCalss);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static Connection getConnection() {
		Connection conn = null;

		try {
			//2. Connection 객체생성 url, user, password
			conn = DriverManager.getConnection(url, user, password);
			//2.1 자동커밋 false 설정
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null)
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			if(pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
