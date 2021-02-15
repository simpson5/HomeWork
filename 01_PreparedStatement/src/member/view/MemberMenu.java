package member.view;

import java.util.List;
import java.util.Scanner;

import member.controller.MemberController;
import member.model.vo.Member;

public class MemberMenu {

	private MemberController memberController = new MemberController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		String menu = "================== 회원 관리 프로그래 ================= \n"
				+ "1. 회원 전체 조회\n"
				+ "2. 회원 아이디 조회\n"
				+ "3. 회원 이름 조회\n"
				+ "4. 회원 가입\n"
				+ "5. 회원 정보변경\n"
				+ "6. 회원 탈퇴\n"
				+ "0. 프로그램 끝내기\n"
				+ "--------------------------------\n"
				+ "선택 : ";
		
		while(true) {
			System.out.print(menu);
			int choice = sc.nextInt();
			Member member = null;
			int result = 0;
			String msg = null;
			List<Member> list = null;
			String memberId = null;
			String memberName = null;
			String memberPassWord = null;
			
			switch(choice) {
				case 1:
					list = memberController.selectAll();
					displayMemberList(list);
					break;
				case 2:
					memberId = inputMemberId(); 
					member = memberController.selectOne(memberId);
					displayMember(member);
					break;
				case 3:
					memberName = inputMemberName();
					list = memberController.selectName(memberName);
					displayMemberList(list);
					break;
				case 4:
					//1. 신규회원정보 입력 -> Member 객체
					member = inputMember();
					System.out.println("신규회원 확인 : " + member);
					//2. controller에 회원가입 요청(메소드 호출) -> int리턴(처리된 행의 개수)
					result = memberController.insertMember(member);
					//3. int에 따른 분기처리
					msg = result > 0 ? "회원 가입 성공!" : "회원 가입 실패!";
					displayMsg(msg);
					break;
				case 5:
					System.out.println("회원정보변경");
					memberId = inputMemberId();
					memberPassWord = inputMemberPassWord();
					member = memberController.confirmMember(memberId,memberPassWord);
					
					if(member == null) {
						System.out.println("회원정보 없거나 비밀번호 틀림");
						break;
					}
					displayMember(member);
					member = modifyMember(member);
					
					result = 0;
					result = memberController.modifyInfo(member);

					msg = result > 0 ? "회원 정보 수정 성공!" : "회원 정보 수정 실패!";
					displayMsg(msg);
					if(result>0) {
						displayMember(member);
					}
					break;
				case 6:
					System.out.println("회원 탈퇴");
					memberId = inputMemberId();
					memberPassWord = inputMemberPassWord();
					member = null;
					member = memberController.confirmMember(memberId,memberPassWord);

					if(member == null) {
						System.out.println("탈퇴할 회원정보 없음.");
						break;
					}

					result = 0;
					result = memberController.deleteInfo(member);

					msg = result > 0 ? "회원 탈퇴 성공!" : "회원 탈퇴 실패!";
					displayMsg(msg);
					if(result>0) {
						displayMember(member);
					}
					break;
				case 0:
					System.out.print("정말로 끝내시겠니까?(y/n) : ");
					if(sc.next().charAt(0) == 'y')
						return;
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	/**
	 * 비밀번호 입력
	 * @return
	 */
	private String inputMemberPassWord() {
		System.out.print("비밀번호 입력 : ");
		return sc.next();
	}

	/**
	 * 조회할 이름 입력
	 * @return
	 */
	private String inputMemberName() {
		System.out.print("조회할 이름 입력 : ");
		return sc.next();
	}
	
	/**
	 * DB에서 조회한 1명의 회원 출력
	 * @param member
	 */
	private void displayMember(Member member) {
		if(member == null) {
			System.out.println(">>>> 조회된 회원이 없습니다.");
		}
		else {
			System.out.println("*****************************************");
				System.out.println(member);
			System.out.println("*****************************************");
		}
		
	}

	/**
	 * 조회할 아이디 입력
	 * @return
	 */
	private String inputMemberId() {
		System.out.println("조회할 아이디 입력 : ");
		return sc.next();
	}

	/**
	 * DB에서 조회된 회원 객체 n개를 출력
	 * @param list
	 */
	private void displayMemberList(List<Member> list) {
		if(list == null || list.isEmpty()) {
			System.out.println(">>> 조회된 행이 없습니다.");
		}
		
		else {
			System.out.println("*****************************************");
			for(Member m : list) {
				System.out.println(m);
			}
			System.out.println("*****************************************");
		}
	}

	/**
	 * DML 처리결과 통보용
	 * @param msg
	 */
	private void displayMsg(String msg) {
		System.out.println(">>> 처리결과 : " +msg);
	}

	/**
	 * 신규 회원 정보
	 * @return
	 */
	private Member inputMember() {
		System.out.println("새로운 회원 정보를 입력하세요.");
		Member member = new Member();
		System.out.println("아이디 : ");
		member.setMemberId(sc.next());
		System.out.println("이름 : ");
		member.setMemberName(sc.next());
		System.out.println("비밀번호 : ");
		member.setPassword(sc.next());
		System.out.println("나이 : ");
		member.setAge(sc.nextInt());
		System.out.println("성별(M/F) : ");
//		member.setGender("" + sc.next().toUpperCase().charAt(0));
		member.setGender(String.valueOf(sc.next().toUpperCase().charAt(0)));
		System.out.println("이메일 : ");
		member.setEmail(sc.next());
		System.out.println("전화번호( - 빼고) : ");
		member.setPhone(sc.next());
		sc.nextLine(); // 버퍼에 남은 개행문자 날리기용 (next계열 - nextLine)
		System.out.println("주소 : ");
		member.setAddress(sc.nextLine());
		System.out.println("취미(,로 나열할 것) : ");
		member.setHobby(sc.next());
		
		return member;
	}
	
	private Member modifyMember(Member member) {
		System.out.println("변경할 회원정보를 입력하세요.");
		
		System.out.print("비밀번호 : ");
		member.setPassword(sc.next());
		
		System.out.print("이메일 : ");
		member.setEmail(sc.next());
		
		System.out.print("전화번호(-빼고 입력) : ");
		member.setPhone(sc.next());
		
		System.out.print("주소 : ");
		sc.nextLine();
		member.setAddress(sc.nextLine());
		
		System.out.print("취미 (,로 나열할것) : ");
		member.setHobby(sc.nextLine());	
		return member;
	}
}
