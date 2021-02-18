package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Service, Dao 클래스의 공통부문을 static 메소드 제공
 * 예외처리를 공통부분에서 작성하므로, 사용(호출)하는 쪽의 코드를 간결히 할 수 있다.
 *
 */
public class JDBCTemplate {
//	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	
	// static 초기화 블럭 = 프로그램 시작시(클래스가 처음 사용될때) 최초 1회만 실행 된다.
	static {
		//data-source.properties의 내용을 읽어서 변수에 대입
		Properties prop = new Properties();
		String fileName = "resources/data-source.properties";
		try {
			prop.load(new FileReader(fileName));
//			System.out.println(prop);
			driverClass = prop.getProperty("driverClass");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			//1. DriverClass등록 (최초 1회)
			Class.forName(driverClass);
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
