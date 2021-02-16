package member.controler;

import java.util.List;

import member.model.service.MemberSerivce;
import member.model.vo.Member;

public class MemberController {
	private MemberSerivce memberService = new MemberSerivce();

	//전체 조회
	public List<Member> selectAll() {
		return memberService.selectAll();
	}
	
	//회원 가입
	public int insertMemeber(Member member) {
		return memberService.insertMember(member);
	}

	//아이디 검색
	public List<Member> searchMemberId(String memberId) {
		return memberService.searchMemberId(memberId);
	}

	//이름 검색
	public List<Member> searchSearchName(String searchName) {
		return memberService.searchSearchName(searchName);
	}

	//로그인
	public Member login(String memberId, String password) {
		return memberService.login(memberId, password);
	}

	//정보 변경
	public int updateInfo(Member member) {
		return memberService.updateInfo(member);
	}

	//회원 탈퇴
	public int deleteMember(Member member) {
		return memberService.deleteMember(member);
	}

}
