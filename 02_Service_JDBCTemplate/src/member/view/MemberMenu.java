package member.view;

import java.util.List;
import java.util.Scanner;

import member.controler.MemberController;
import member.model.vo.Member;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);
	protected MemberController memberController = new MemberController();

	public void mainMenu() {
		String menu = "================== 회원 관리 프로그래 ================= \n"
					+ "1. 회원 전체 조회\n"
					+ "2. 회원 아이디 조회\n"
					+ "3. 회원 이름 조회\n"
					+ "4. 회원 가입\n"
					+ "5. 회원 정보변경, 탈퇴\n"
					+ "0. 프로그램 끝내기\n"
					+ "--------------------------------\n"
					+ "선택 : ";
		
		do {
			System.out.print(menu);
			String choice = sc.next();
			List<Member> list = null;
			Member member = null;
			String msg = "";
			int result = 0;
			String memberId = "";
			String searchName= "";
			String password= "";
			
			
			switch(choice) {
				case "1":
					list = memberController.selectAll();
					displayMemberList(list);
					break;
				case "2":
					System.out.print("검색할 ");
					memberId = inputMemeberId();
					list = memberController.searchMemberId(memberId);
					displayMemberList(list);
					break;
				case "3":
					System.out.print("검색할 ");
					searchName = inputSearchName();
					list = memberController.searchSearchName(searchName);
					displayMemberList(list);
					break;
				case "4":
					member = inputMember();
					result = memberController.insertMemeber(member);
					msg = result > 0 ? "회원 가입 성공!" : "회원 가입 실패!";
					displayMsg(msg);
					if(result>0) displayMember(member);
					break;
				//회원 정보 변경
				case "5":
					//로그인
					member = memberLogin(memberId, password, msg, member);
					//서브메뉴
					if(member != null) {
						new SubMenu().updateMenu(member);
					}
					System.out.println("");
					break;
				case "0":
					System.out.print("정말 종료할거야? : ");
					if(sc.next().charAt(0) == 'y')
						return;
					break;
				default : 
					System.out.println("잘못 입력하셨습니다.");
			}
		} while(true);
	}

	private Member memberLogin(String memberId, String password, String msg, Member member) {
		System.out.println("로그인");
		memberId = inputMemeberId();
		password = inputPassword();
		member = memberController.login(memberId, password);
		msg = member != null ? "로그인 성공!" : "로그인 실패!";
		displayMsg(msg);
		return member;
	}

	/**
	 * 비밀번호 입력
	 * @return
	 */
	protected String inputPassword() {
		System.out.print("비밀번호 입력 : ");
		return sc.next();
	}
	
	/**
	 * 이름 입력
	 * @return
	 */
	private String inputSearchName() {
		System.out.print("이름 : ");
		return sc.next();
	}

	/**
	 * 아이디 입력
	 * @return
	 */
	private String inputMemeberId() {
		System.out.print("아이디 : ");
		return sc.next();
	}

	/**
	 * 한명의 정보 출력
	 * @param member
	 */
	private void displayMember(Member member) {
		System.out.println(member);
	}

	/**
	 * 작동 결과 출력
	 * @param msg
	 */
	protected void displayMsg(String msg) {
		System.out.println(">>> " + msg);
		
	}

	/**
	 * 가입할 회원의 정보 입력
	 * @return
	 */
	private Member inputMember() {
		System.out.print("새로운 회원 정보를 입력하세요.");
		Member member = new Member();
		System.out.print("아이디 : ");
		member.setMemberId(sc.next());
		System.out.print("이름 : ");
		member.setMemberName(sc.next());
		System.out.print("비밀번호 : ");
		member.setPassword(sc.next());
		System.out.print("나이 : ");
		member.setAge(sc.nextInt());
		System.out.print("성별(M/F) : ");
		member.setGender(String.valueOf(sc.next().toUpperCase().charAt(0)));
		System.out.print("이메일 : ");
		member.setEmail(sc.next());
		System.out.print("전화번호( - 빼고) : ");
		member.setPhone(sc.next());
		sc.nextLine(); // 버퍼에 남은 개행문자 날리기용 (next계열 - nextLine)
		System.out.print("주소 : ");
		member.setAddress(sc.nextLine());
		System.out.print("취미(,로 나열할 것) : ");
		member.setHobby(sc.next());
		
		return member;
	}

	/**
	 * n행의 회원 정보 출력
	 * @param list
	 */
	private void displayMemberList(List<Member> list) {
		if(list == null || list.isEmpty()) {
			return;
		}
		
		System.out.println("======================");
		for(Member m : list) {
			System.out.println(m);
		}
		System.out.println("======================");
	}

}
