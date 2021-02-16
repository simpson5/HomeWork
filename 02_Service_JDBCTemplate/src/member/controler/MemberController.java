package member.controler;

import java.util.List;

import member.model.service.MemberSerivce;
import member.model.vo.Member;

public class MemberController {
	private MemberSerivce memberService = new MemberSerivce();
	

	public List<Member> selectAll() {
		return memberService.selectAll();
	}
	
	public int insertMemeber(Member member) {
		return memberService.insertMember(member);
	}

	public List<Member> searchMemberId(String memberId) {
		return memberService.searchMemberId(memberId);
	}

	public List<Member> searchSearchName(String searchName) {
		return memberService.searchSearchName(searchName);
	}

	public Member login(String memberId, String password) {
		return memberService.login(memberId, password);
	}

	public int updateInfo(Member member) {
		return memberService.updateInfo(member);
	}

	public int deleteMember(Member member) {
		return memberService.deleteMember(member);
	}

}
