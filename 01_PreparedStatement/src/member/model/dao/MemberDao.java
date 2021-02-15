package member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.Member;

/**
 * DAO
 * Data Access Object
 * DB에 접근하는 클래스
 * 
 1. 드라이버 클래스 등록(최초 1회)
 2. Connection객체 생성(url, user, password)
 3. 자동 커밋 여부 설정 : true(기본값) / false -> app에서 직접 트랜젝션 제어
 4. preparedStatement객체생성(미완성 쿼리) 및 값 대입
 5. Statement 객체 실행. DB에 쿼리 요청
 6. 응답처리 DML : int 리턴, DQL : ResultSet 리턴 -> 자바객체로 전환
 7. 트랜잭션처리(DML)
 8. 자원반납(생성의 역순)
 */
public class MemberDao {
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "student";
	String password = "student";

	//회원 가입
	public int insertMember(Member member) {
		Connection conn = null;
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, default)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			//1. 드라이버 클래스 등록(최초 1회)
			Class.forName(driverClass);
			//2. Connection객체 생성(url, user, password)
			conn = DriverManager.getConnection(url, user, password);
			//3. 자동 커밋 여부 설정(DML) : true(기본값) / false -> app에서 직접 트랜젝션 제어
			conn.setAutoCommit(false);
			//4. preparedStatement객체생성(미완성 쿼리) 및 값 대입
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
			
			//5. Statement 객체 실행. DB에 쿼리 요청
			//6. 응답처리 DML : int 리턴, DQL : ResultSet 리턴 -> 자바객체로 전환
			result = pstmt.executeUpdate();
			
			//7. 트랜잭션처리(DML)
			if (result > 0 )
				conn.commit();
			else
				conn.rollback();

		} catch (ClassNotFoundException e) {
			// ojdbc6.jar 프로젝트 연동 실패!
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//8. 자원반납(생성의 역순)
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	//전체 조회
	public List<Member> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member order by enroll_date desc";
		List<Member> list = null;
		
		try {
			//1. 드라이버 클래스 등록(최초 1회)
			Class.forName(driverClass);
			//2. Connection객체 생성(url, user, password)
			//3. 자동 커밋 여부 설정 : true(기본값) / false -> app에서 직접 트랜젝션 제어
			conn = DriverManager.getConnection(url, user, password);
			//4. preparedStatement객체생성(미완성 쿼리) 및 값 대입
			pstmt = conn.prepareStatement(sql);
			//5. Statement 객체 실행. DB에 쿼리 요청
			rset = pstmt.executeQuery();
			//6. 응답처리 DML : int 리턴, DQL : ResultSet 리턴 -> 자바객체로 전환
			//다음행 존재 여부 리턴. 커서가 다음행 접근.
			list = new ArrayList<>();
			while(rset.next()) {
				//컬럼명은 대소문자를 구분하지 않는다.
				String memberId = rset.getString("member_id");
				String password = rset.getString("password");
				String memberName = rset.getString("member_name");
				String gender = rset.getString("gender");
				int age = rset.getInt("password");
				String email= rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				String hobby = rset.getString("hobby");
				Date enrollDate = rset.getDate("enroll_date");
				
				Member member = new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
				list.add(member);
			}
			//7. 트랜잭션처리(DML)
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//8. 자원반납(생성의 역순)
			try {
				if(rset != null)
					rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	//아이디로 한명 조회
	public Member selectOne(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member where member_id = ? ";
		Member member = null;
		
		try {
			//1. 드라이버 클래스 등록(최초 1회)
			Class.forName(driverClass);
			//2. Connection객체 생성(url, user, password)
			//3. 자동 커밋 여부 설정 : true(기본값) / false -> app에서 직접 트랜젝션 제어
			conn = DriverManager.getConnection(url, user, password);
			//4. preparedStatement객체생성(미완성 쿼리) 및 값 대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			//5. Statement 객체 실행. DB에 쿼리 요청
			rset = pstmt.executeQuery();
			//6. 응답처리 DML : int 리턴, DQL : ResultSet 리턴 -> 자바객체로 전환
			//다음행 존재 여부 리턴. 커서가 다음행 접근.
			while(rset.next()) {
				//컬럼명은 대소문자를 구분하지 않는다.
				memberId = rset.getString("member_id");
				String password = rset.getString("password");
				String memberName = rset.getString("member_name");
				String gender = rset.getString("gender");
				int age = rset.getInt("password");
				String email= rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				String hobby = rset.getString("hobby");
				Date enrollDate = rset.getDate("enroll_date");
				
				member = new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
			}
			//7. 트랜잭션처리(DML)
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//8. 자원반납(생성의 역순)
			try {
				if(rset != null)
					rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return member;
	}
	
	//이름 검색
	public List<Member> selectName(String memberName) {
		Connection conn = null;
		String sql = "select * from member where member_name like ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		List<Member> list = null;
		try {
			Class.forName(driverClass);
			// 2. Connection 객체 생성(db서버의 URL, user, passWord)
			// 3. 자동커밋 여부 : true(기본값) = 자동커밋 / false = 수동커밋
			conn = DriverManager.getConnection(url, user, password);
			
			// 4. PreparedStatement 객체생성(미완성 쿼리) 및 값 대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + memberName + "%");
			
			// 5. Statement 객체 실행. DB에 쿼리 요청
			rset = pstmt.executeQuery();
			
			// 6. 응답처리 : DML=int리턴, DQL=ResultSet리턴 -> 자바객체로 전환 과정 필요
			list = new ArrayList<>();
			while(rset.next()) {
				String memberId = rset.getString("member_id");
				String password = rset.getString("password");
				String memberName2 = rset.getString("member_name");
				String gender = rset.getString("gender"); 
				int age = rset.getInt("age");
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				String hobby = rset.getString("hobby");
				Date enrollDate = rset.getDate("enroll_date");
				
				member = new Member(memberId, password, memberName2, gender, age, email, phone, address, hobby, enrollDate);
				list.add(member);
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	//정보 변경
	public int modifyInfo(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update member set password = ?, email = ?, phone = ?, address = ?, hobby = ? where member_id = ?";
		
		try {
			// 1. Driver클래스 등록(최초 1회만 하면됨)
			Class.forName(driverClass);

			// 2. Connection 객체 생성(db서버의 URL, user, passWord)
			conn = DriverManager.getConnection(url, user, password);

			// 3. 자동커밋 여부 : true(기본값) = 자동커밋 / false = 수동커밋
			conn.setAutoCommit(false);

			// 4. PreparedStatement 객체생성(미완성 쿼리) 및 값 대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getHobby());
			pstmt.setString(6, member.getMemberId());

			// 5. Statement 객체 실행. DB에 쿼리 요청
			// 6. 응답처리 : DML=int리턴, DQL=ResultSet리턴 -> 자바객체로 전환 과정 필요
			result = pstmt.executeUpdate();

			// 7. DML인경우 트랜잭션 처리
			if (result > 0)
				conn.commit();
			else
				conn.rollback();

		} catch (ClassNotFoundException e) {
			// ojdbc6.jar를 프로젝트와 연동실패
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 8. 자원반납(생성의 역순)
		finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//회원 삭제
	public int deleteInfo(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete member where member_id = ?";

		try {
			// 1. Driver클래스 등록(최초 1회만 하면됨)
			Class.forName(driverClass);

			// 2. Connection 객체 생성(db서버의 URL, user, passWord)
			conn = DriverManager.getConnection(url, user, password);

			// 3. 자동커밋 여부 : true(기본값) = 자동커밋 / false = 수동커밋
			conn.setAutoCommit(false);

			// 4. PreparedStatement 객체생성(미완성 쿼리) 및 값 대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());

			// 5. Statement 객체 실행. DB에 쿼리 요청
			// 6. 응답처리 : DML=int리턴, DQL=ResultSet리턴 -> 자바객체로 전환 과정 필요
			result = pstmt.executeUpdate();

			// 7. DML인경우 트랜잭션 처리
			if (result > 0)
				conn.commit();
			else
				conn.rollback();

		} catch (ClassNotFoundException e) {
			// ojdbc6.jar를 프로젝트와 연동실패
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 8. 자원반납(생성의 역순)
		finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//회원 확인
	public Member confirmMember(String memberId, String memberPassword) {
		Connection conn = null;
		String sql = "select * from member where member_id = ? and password = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		try {
			Class.forName(driverClass);
			// 2. Connection 객체 생성(db서버의 URL, user, passWord)
			// 3. 자동커밋 여부 : true(기본값) = 자동커밋 / false = 수동커밋
			conn = DriverManager.getConnection(url, user, password);
			
			// 4. PreparedStatement 객체생성(미완성 쿼리) 및 값 대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPassword);
			// 5. Statement 객체 실행. DB에 쿼리 요청
			rset = pstmt.executeQuery();
			
			// 6. 응답처리 : DML=int리턴, DQL=ResultSet리턴 -> 자바객체로 전환 과정 필요
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
				
				member = new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
			}
			// 7. DML인경우 트랜잭션 처리
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}
}
