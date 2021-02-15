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

	public int insertMember(Member member) {
		return memberDao.insertMember(member);
	}

	public List<Member> selectAll() {
		return memberDao.selectAll();
	}

	public Member selectOne(String memberId) {
		return memberDao.selectOne(memberId);
	}
	
	public List<Member> selectName(String memberName) {
		return memberDao.selectName(memberName);
	}
		
	public int modifyInfo(Member member) {
		return memberDao.modifyInfo(member);
	}
	
	public int deleteInfo(Member member) {
		return memberDao.deleteInfo(member);
	}
	
	public Member confirmMember(String memberId, String memberPassword) {
		return memberDao.confirmMember(memberId, memberPassword);
	}
}
