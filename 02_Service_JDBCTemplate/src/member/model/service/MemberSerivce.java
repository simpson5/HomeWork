package member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

import static common.JDBCTemplate.*;

/**
 Service
 1. DriverClass등록 (최초 1회)
 2. Connection 객체생성 url, user, password
 2.1 자동커밋 false 설정
 --------- Dao 요청 ----------
 6. 트랜잭션 처리 commit / rollback
 7. 자원반납(생성역순 conn)
 
 Dao
 3. PreparedStatement 객체 생성 (미완성 쿼리)
 3.1 ? 값 대임
 4. 실행 : DML(executeUpdate) -> int, DQL(excuteQuery) -> ResultSet
 4.1 ResultSet -> Java 객체 옮겨담기
 5. 자원반납(생성역순 rset - pstmt)
 * 
 */

public class MemberSerivce {
	
	private MemberDao memberDao = new MemberDao();
	
	// 전체 조회
	public List<Member> selectAll() {
		Connection conn = getConnection();
		List<Member> list = memberDao.selectAll(conn);
		close(conn);
		return list;
	}

	// 회원 가입
	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = memberDao.insetMember(conn, member);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	// 아이디로 조회
	public List<Member> searchMemberId(String memberId) {
		Connection conn = getConnection();
		List<Member> list = memberDao.searchMemberId(conn, memberId);
		close(conn);
		return list;
	}

	// 이름으로 조회
	public List<Member> searchSearchName(String searchName) {
		Connection conn = getConnection();
		List<Member> list = memberDao.searchSearchName(conn, searchName);
		close(conn);
		return list;
	}

	// 로그인
	public Member login(String memberId, String password) {
		Connection conn = getConnection();
		Member member = memberDao.login(conn, memberId, password);
		close(conn);
		return member;
	}

	// 정보변경(암호, 주소, 이메일, 전화번호)
	public int updateInfo(Member member) {
		Connection conn = getConnection();
		int result = memberDao.updateInfo(conn, member);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	// 회원 탈퇴
	public int deleteMember(Member member) {
		Connection conn = getConnection();
		int result = memberDao.deleteMember(conn, member);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}

/*
public List<Member> selectAll_() {
	String driverCalss = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "student";
	String password = "student";
	Connection conn = null;
	List<Member> list = null;
	
	try {
		//1. DriverClass등록 (최초 1회)
		Class.forName(driverCalss);
		//2. Connection 객체생성 url, user, password
		conn = DriverManager.getConnection(url, user, password);
		//2.1 자동커밋 false 설정
		conn.setAutoCommit(false);
		//--------- Dao 요청 ----------
		//Connection 객체 전달
		list = memberDao.selectAll(conn);
		//6. 트랜잭션 처리 commit / rollback
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		//7. 자원반납(생성역순 conn)
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return list;
}
*/
