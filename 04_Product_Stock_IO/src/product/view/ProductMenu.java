package product.view;

import java.util.List;
import java.util.Scanner;

import product.controller.ProductController;
import product.model.vo.Product;

public class ProductMenu {
	protected Scanner sc = new Scanner(System.in);
	protected ProductController productController = new ProductController();
	protected List<Product> list = null;
	
	public void mainMenu() {
		String mainmenu = "***** 상품재고관리프로그램 *****\n"
				+ "1. 전체상품조회\n"
				+ "2. 상품아이디검색\n"
				+ "3. 상품명검색\n"
				+ "4. 상품추가\n"
				+ "5. 상품정보변경\n"
				+ "6. 상품삭제\n"
				+ "7. 상품입/출고 메뉴\n"
				+ "9. 프로그램종료\n"
				+ "------------------------------------- \n"
				+ "입력 : ";
		while(true) {
			System.out.print(mainmenu);
			String choice = sc.next();
			Product product = null;
			String productId = ""; 
			int result = 0;
			
			switch(choice) {
			//전체 상품 조회
			case "1" :
				list = productController.selectAll();
				displayProduct(list);
				break;
			//상품 아이디 검색
			case "2" :
				System.out.print("검색할 상품 아이디 입력 : ");
				productId = sc.next();
				product = productController.selectId(productId);
				displayProduct(list);
				break;
			//상품명 검색
			case "3" :
				System.out.print("검색할 상품명 입력 : ");
				String productName = sc.next();
				list = productController.selectName(productName);
				displayProduct(list);
				break;
			//상품 추가
			case "4" :
				product = inputProduct();
				result = productController.inputProduct(product);
				display("상품 추가",result);
				System.out.println(product);
				break;
			//상품 정보 변경 메뉴
			case "5" :
				System.out.print("변경할 상품 아이디 입력 : ");
				productId = sc.next();
				product = productController.selectId(productId);
				if(product != null)
					new UpdateInfoMenu().subMenu(product);
				break;
			//상품 삭제
			case "6" :
				System.out.print("삭제할 상품 아이디 입력 : ");
				productId = sc.next();
				product = productController.selectId(productId);
				if(product != null)
					result = productController.deletProduct(product);
				display("상품 삭제",result);
				break;
			//상품 입/출고 메뉴
			case "7" :
				new IOmenu().subMenu();
				break;
			//프로그램 종료
			case "9" :
				System.out.println("정말로 종료 하시겠습니까?");
				if(sc.next().toUpperCase().charAt(0) == 'Y')
					return;
				break;
			default :
				System.out.println("잘못 입력 하셨습니다.");
			}
		}
		
	}

	/**
	 * 상태 메세지 출력
	 * @param msg
	 * @param result
	 */
	protected void display(String msg, int result) {
		if(result > 0) {
			System.out.println(msg + " 성공!");
		}
		else {
			System.out.println(msg + " 실패!");
		}
	}

	/**
	 * 상품 정보 입력
	 * @return
	 */
	private Product inputProduct() {
		System.out.print("아이디 입력 : ");
		String productId = sc.next();
		System.out.print("상품명 입력 : ");
		String productName = sc.next();
		System.out.print("가격 입력 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("설명 입력 : ");
		String description = sc.nextLine();
		return new Product(productId, productName, price, description, 0);
	}

	/**
	 * 조회한 정보 출력
	 * @param list
	 */
	protected void displayProduct(List<Product> list) {
		if(list == null || list.isEmpty()) {
			System.out.println("조회할 목록이 없습니다.");
			return;
		}
		System.out.println("===============================================");
		for(Product p : list) {
			System.out.println(p);
		}
		System.out.println("===============================================");
	}

	/**
	 * 에러 출력
	 * @param message
	 */
	public void displayErr(String message) {
		System.err.println(message);
		
	}

}
