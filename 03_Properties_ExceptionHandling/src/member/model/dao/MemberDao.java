package member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.exception.MemberException;
import member.model.vo.Member;

import static common.JDBCTemplate.*;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	/**
	 * 1. MemberDao객체 생성시(최초 1회)
	 * member-query.properties의 내용을 읽어다 prop에 저장한다.
	 * 
	 * 2. dao메소드 호출시마다 prop으로부터 query를 가져다 사용한다.
	 */
	public MemberDao() {
		String fileName = "resources/member-query.properties";
		try {
			prop.load(new FileReader(fileName));
//			System.out.println(prop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//전체 조회
	public List<Member> selectAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAll");
		List<Member> list = null;

		try {
			//3. PreparedStatement 객체 생성 (미완성 쿼리)
			//3.1 ? 값 대임
			pstmt = conn.prepareStatement(sql);
			//4. 실행 : DML(executeUpdate) -> int, DQL(excuteQuery) -> ResultSet
			rset = pstmt.executeQuery();
			//4.1 ResultSet -> Java 객체 옮겨담기
			list = new ArrayList<>();
			while(rset.next()) {
				String memberId = rset.getString("member_id");
				String password = rset.getString("password");
				String memberName = rset.getString("member_name");
				String gender = rset.getString("gender");
				int age = rset.getInt("age");
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				String hobby = rset.getString("hobby");
				Date enrollDate = rset.getDate("enroll_date");

				Member member = new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
				list.add(member);
			}

		} catch (SQLException e) {
			//e.printStackTrace();
			//예외를 전환 : RuntimeException, 의미분명한 커스텀 예외객체로 전환
			throw new MemberException("회원 전체 조회", e);
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(rset);
			close(pstmt);
		}
		return list;
	}

	//회원 가입
	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertMember");
		try {
			//3. PreparedStatement 객체 생성 (미완성 쿼리)
			//3.1 ? 값 대임
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getGender());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getAddress());
			pstmt.setString(9, member.getHobby());
			//4. 실행 : DML(executeUpdate) -> int, DQL(excuteQuery) -> ResultSet
			//4.1 ResultSet -> Java 객체 옮겨담기
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new MemberException("회원 가입", e);
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(pstmt);
		}
		return result;
	}

	// 아이디로 조회
	public List<Member> searchMemberId(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchMemberId");
		List<Member> list = null;

		try {
			//3. PreparedStatement 객체 생성 (미완성 쿼리)
			//3.1 ? 값 대임
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + memberId + "%");
			//4. 실행 : DML(executeUpdate) -> int, DQL(excuteQuery) -> ResultSet
			rset = pstmt.executeQuery();
			//4.1 ResultSet -> Java 객체 옮겨담기
			list = new ArrayList<>();
			while(rset.next()) {
				memberId = rset.getString("member_iddd");
				String password = rset.getString("password");
				String memberName = rset.getString("member_name");
				String gender = rset.getString("gender");
				int age = rset.getInt("age");
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				String hobby = rset.getString("hobby");
				Date enrollDate = rset.getDate("enroll_date");

				Member member = new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
				list.add(member);
			}

		} catch (SQLException e) {
			throw new MemberException("아이디 검색", e);
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(rset);
			close(pstmt);
		}

		return list;
	}

	// 이름으로 조회
	public List<Member> searchMemberName(Connection conn, String searchName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchMemberName");
		List<Member> list = null;

		try {
			//3. PreparedStatement 객체 생성 (미완성 쿼리)
			//3.1 ? 값 대임
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchName + "%");
			//4. 실행 : DML(executeUpdate) -> int, DQL(excuteQuery) -> ResultSet
			rset = pstmt.executeQuery();
			//4.1 ResultSet -> Java 객체 옮겨담기
			list = new ArrayList<>();
			while(rset.next()) {
				String memberId = rset.getString("member_id");
				String password = rset.getString("password");
				String memberName = rset.getString("member_name");
				String gender = rset.getString("gender");
				int age = rset.getInt("age");
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				String hobby = rset.getString("hobby");
				Date enrollDate = rset.getDate("enroll_date");

				Member member = new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
				list.add(member);
			}

		} catch (SQLException e) {
			throw new MemberException("이름 검색", e);
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(rset);
			close(pstmt);
		}



		return list;
	}

	// 로그인
	public Member memberLogin(Connection conn, String memberId, String password) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("memberLogin");
		Member member = null;

		try {
			//3. PreparedStatement 객체 생성 (미완성 쿼리)
			//3.1 ? 값 대임
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, password);
			//4. 실행 : DML(executeUpdate) -> int, DQL(excuteQuery) -> ResultSet
			rset = pstmt.executeQuery();
			//4.1 ResultSet -> Java 객체 옮겨담기
			while(rset.next()) {
//				if(memberId != rset.getString("member_id") ||
//				password != rset.getString("password")) {
//					break;
//				}
				String memberName = rset.getString("member_name");
				String gender = rset.getString("gender");
				int age = rset.getInt("age");
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				String hobby = rset.getString("hobby");
				Date enrollDate = rset.getDate("enroll_date");

				member = new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
			}
		} catch (SQLException e) {
			throw new MemberException("로그인", e);
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(rset);
			close(pstmt);
		}

		return member;
	}

	//회원 정보 변경(암호, 주소, 이메일, 전화번호)
	public int updateInfo(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateInfo");
		int result = 0;
		
		try {
			//3. PreparedStatement 객체 생성 (미완성 쿼리)
			//3.1 ? 값 대임
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getHobby());
			pstmt.setString(6, member.getMemberId());
			//4. 실행 : DML(executeUpdate) -> int, DQL(excuteQuery) -> ResultSet
			//4.1 ResultSet -> Java 객체 옮겨담기
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new MemberException("정보 변경", e);
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(pstmt);
		}
		
		return result;
	}

	// 회원 탈퇴
	public int deleteMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		int result = 0;
		
		try {
			//3. PreparedStatement 객체 생성 (미완성 쿼리)
			//3.1 ? 값 대임
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			//4. 실행 : DML(executeUpdate) -> int, DQL(excuteQuery) -> ResultSet
			//4.1 ResultSet -> Java 객체 옮겨담기
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new MemberException("탈퇴", e);
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(pstmt);
		}
		
		return result;
	}

	public List<Member> deletMemberAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("deletMemberAll");
		List<Member> list = null;

		try {
			//3. PreparedStatement 객체 생성 (미완성 쿼리)
			//3.1 ? 값 대임
			pstmt = conn.prepareStatement(sql);
			//4. 실행 : DML(executeUpdate) -> int, DQL(excuteQuery) -> ResultSet
			rset = pstmt.executeQuery();
			//4.1 ResultSet -> Java 객체 옮겨담기
			list = new ArrayList<>();
			while(rset.next()) {
				String memberId = rset.getString("member_id");
				String password = rset.getString("password");
				String memberName = rset.getString("member_name");
				String gender = rset.getString("gender");
				int age = rset.getInt("age");
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				String hobby = rset.getString("hobby");
				Date enrollDate = rset.getDate("enroll_date");

				Member member = new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
				list.add(member);
			}

		} catch (SQLException e) {
			//e.printStackTrace();
			//예외를 전환 : RuntimeException, 의미분명한 커스텀 예외객체로 전환
			throw new MemberException("탈퇴 회원 조회", e);
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int createTrigMemDel(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("createTrigMemDel");
		int result = 0;
		
		try {
			//3. PreparedStatement 객체 생성 (미완성 쿼리)
			//3.1 ? 값 대임
			pstmt = conn.prepareStatement(sql);
			//4. 실행 : DML(executeUpdate) -> int, DQL(excuteQuery) -> ResultSet
			//4.1 ResultSet -> Java 객체 옮겨담기
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new MemberException("트리거 생성", e);
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(pstmt);
		}
		
		return result;
	}
}
