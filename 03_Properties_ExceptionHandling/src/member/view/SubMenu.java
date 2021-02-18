package member.view;

import java.util.Scanner;

import member.model.vo.Member;


public class SubMenu extends MemberMenu {
	private Scanner sc = new Scanner(System.in);

	public void updateMenu(Member member) {
		String menu = "================== 정보 변경 ================= \n"
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
			String choice = sc.next();
			String msg = "";
			int result = 0;
			String update = "";
			
			switch(choice) {
			case "1":
				System.out.print("변경할 비밀번호 : ");
				update = update();
				member.setPassword(update);
				result(result, msg, member);
				break;
			case "2":
				System.out.print("변경할 이메일 : ");
				update = update();
				member.setEmail(update);
				result(result, msg, member);
				break;
			case "3":
				System.out.print("변경할 전봐번호 : ");
				update = update();
				member.setPhone(update);
				result(result, msg, member);
				break;
			case "4":
				System.out.print("변경할 주소 : ");
				update = update();
				member.setAddress(update);
				result(result, msg, member);
				break;
			case "5":
				System.out.print("정말 탈퇴 하시겠습니까? : ");
				if(sc.next().charAt(0) == 'y') {
					result = memberController.deleteMember(member);
					msg = result > 0 ? "탈퇴 성공!" : "탈퇴 실패!";
					displayMsg(msg);
					return;
				}
				break;
			case "0":
				System.out.print("더 이상 변경할 내용이 없습니까? : ");
				if(sc.next().charAt(0) == 'y')
					return;
				break;
			default : 
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	private void result(int result, String msg, Member member) {
		result = memberController.updateInfo(member);
		msg = result > 0 ? "정보 변경 성공!" : "정보 변경 실패!";
		displayMsg(msg);
	}

	private String update() {
		return sc.next();
	}
}
