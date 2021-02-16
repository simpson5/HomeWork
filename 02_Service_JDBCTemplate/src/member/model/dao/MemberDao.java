package member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.Member;

import static common.JDBCTemplate.*;

public class MemberDao {

	public List<Member> selectAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member order by enroll_date desc";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int insetMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, default)";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(pstmt);
		}
		return result;
	}

	public List<Member> searchMemberId(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member where member_id like ?";
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
				memberId = rset.getString("member_id");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Member> searchSearchName(Connection conn, String searchName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member where member_name like ?";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(rset);
			close(pstmt);
		}



		return list;
	}

	// 로그인
	public Member login(Connection conn, String memberId, String password) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member where member_id = ? and password = ?";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(rset);
			close(pstmt);
		}

		return member;
	}

	//회원 정보 변경
	public int updateInfo(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String sql = "update member set password = ?, email = ?, phone = ?, address = ?, hobby = ? where member_id = ?";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String sql = "delete member where member_id = ?";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(pstmt);
		}
		
		return result;
	}
}
