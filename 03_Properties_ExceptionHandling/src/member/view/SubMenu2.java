package member.view;

import member.model.vo.Member;

public class SubMenu2 extends MemberMenu {

	public void loginMenu(Member member) {
		String menu = "================== 회원 관리 프로그래 ================= \n"
				+ "1. 비밀번호 변경\n"
				+ "2. 이메일 변경\n"
				+ "3. 전화번호 변경\n"
				+ "4. 주소 변경\n"
				+ "5. 회원 탈퇴\n"
				+ "0. 돌아가기\n"
				+ "--------------------------------\n"
				+ "선택 : ";
		
		while(true) {
			System.out.print(menu);
		}
		
	}

}
