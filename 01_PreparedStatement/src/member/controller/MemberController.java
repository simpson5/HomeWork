package member.controller;

import java.util.List;

import member.model.dao.MemberDao;
import member.model.vo.Member;

/**
 * MVC 패턴의 시작점이자 전체 흐름을 제어.
 * 
 * view단으로부터 요청을 받아서 dao에 다시 요청.
 * 그 결과를 view단에 다시 전달.
 */
public class MemberController {
	private MemberDao memberDao = new MemberDao();

	//회원 가입
	public int insertMember(Member member) {
		return memberDao.insertMember(member);
	}

	//전체 조회
	public List<Member> selectAll() {
		return memberDao.selectAll();
	}

	//아이디로 한명 조회
	public Member selectOne(String memberId) {
		return memberDao.selectOne(memberId);
	}
	
	//이름으로 여러명 조회
	public List<Member> selectName(String memberName) {
		return memberDao.selectName(memberName);
	}
		
	//회원 정보 변경
	public int modifyInfo(Member member) {
		return memberDao.modifyInfo(member);
	}
	
	//회원 삭제
	public int deleteInfo(Member member) {
		return memberDao.deleteInfo(member);
	}
	
	//회원 확인
	public Member confirmMember(String memberId, String memberPassword) {
		return memberDao.confirmMember(memberId, memberPassword);
	}
}
