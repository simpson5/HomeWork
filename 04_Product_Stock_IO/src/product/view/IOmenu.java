package product.view;

import java.sql.Date;

import product.model.vo.ProductIO;

public class IOmenu extends ProductMenu {
	public void subMenu() {
		String menu = "***** 상품입출고메뉴 *****\n"
				+ "1. 전체입출고내역조회\n"
				+ "2. 상품입고\n"
				+ "3. 상품출고\n"
				+ "9. 돌아가기\n"
				+ "------------------------------------- \n"
				+ "입력 : ";
		
		while(true) {
			System.out.print(menu);
			String choice = sc.next();
			ProductIO productIO = null;
			int result = 0;
			
			switch(choice) {
			//전체입출고내역조회
			case "1" :
				list = productController.IOselectAll();
				displayProduct(list);
				break;
			//상품입고
			case "2" :
				System.out.println("입고");
				productIO = inputProductIO("I", "입고 할");
				result = productController.inputProductIO(productIO);
				display("상품 입고",result);
				break;
			//상품출고
			case "3" :
				System.out.println("출고");
				productIO = inputProductIO("O", "출고 할");
				result = productController.inputProductIO(productIO);
				display("상품 출고",result);
				break;
			//돌아가기
			case "9" :
				System.out.println("돌아가시겠습니까?");
				if(sc.next().toUpperCase().charAt(0) == 'Y')
					return;
				break;
			default :
				System.out.println("잘못 입력 하셨습니다.");
			}
		}
	}

	private ProductIO inputProductIO(String status, String msg) {
		System.out.print("상품 아이디 : ");
		String productId = sc.next();
		System.out.print(msg + " 상품 수 : ");
		int amount = sc.nextInt();
		return new ProductIO(productId, amount, status);
	}
}
