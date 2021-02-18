package member.controler;

import java.util.List;

import member.model.exception.MemberException;
import member.model.service.MemberSerivce;
import member.model.vo.Member;
import member.view.MemberMenu;

public class MemberController {
	private MemberSerivce memberService = new MemberSerivce();

	//전체 조회
	public List<Member> selectAll() {
		List<Member> list = null;
		try {
			list = memberService.selectAll();
		} catch(MemberException e) {
			//서버로깅
			//관리자 이메일 알림
			new MemberMenu().displayError(e.getMessage() + " : 관리자에게 문의하세요");
		}
		return list;
	}
	
	//회원 가입
	public int insertMemeber(Member member) {
		int result = 0;
		try {
			result = memberService.insertMember(member);
		} catch(MemberException e) {
			new MemberMenu().displayError(e.getMessage() + " : 관리자에게 문의하세요");
		}
		return result;
	}

	//아이디 검색
	public List<Member> searchMemberId(String memberId) {
		List<Member> list = null;
		try {
			list = memberService.searchMemberId(memberId);
		} catch(MemberException e) {
			//서버로깅
			//관리자 이메일 알림
			new MemberMenu().displayError(e.getMessage() + " : 관리자에게 문의하세요");
		}
		return list;
	}

	//이름 검색
	public List<Member> searchSearchName(String searchName) {
		List<Member> list = null;
		try {
			list = memberService.searchSearchName(searchName);
		} catch(MemberException e) {
			//서버로깅
			//관리자 이메일 알림
			new MemberMenu().displayError(e.getMessage() + " : 관리자에게 문의하세요");
		}
		return list;
	}

	//로그인
	public Member memberLogin(String memberId, String password) {
		Member member = null;
		try {
			member = memberService.memberLogin(memberId, password);
		} catch(MemberException e) {
			//서버로깅
			//관리자 이메일 알림
			new MemberMenu().displayError(e.getMessage() + " : 관리자에게 문의하세요");
		}
		return member;
	}

	//정보 변경
	public int updateInfo(Member member) {
		int result = 0;
		try {
			result = memberService.updateInfo(member);
		} catch(MemberException e) {
			new MemberMenu().displayError(e.getMessage() + " : 관리자에게 문의하세요");
		}
		return result;
	}

	//회원 탈퇴
	public int deleteMember(Member member) {
		int result = 0;
		try {
			result = memberService.deleteMember(member);
		} catch(MemberException e) {
			new MemberMenu().displayError(e.getMessage() + " : 관리자에게 문의하세요");
		}
		return result;
	}

	public List<Member> deletMemberAll() {
		List<Member> list = null;
		try {
			list = memberService.deletMemberAll();
		} catch(MemberException e) {
			new MemberMenu().displayError(e.getMessage() + " : 관리자에게 문의하세요");
		}
		return list;
	}

	public int createTrigMemDel() {
		int result = 0;
		try {
			result = memberService.createTrigMemDel();
		} catch(MemberException e) {
			new MemberMenu().displayError(e.getMessage() + " : 관리자에게 문의하세요");
		}
		return result;
	}

}
