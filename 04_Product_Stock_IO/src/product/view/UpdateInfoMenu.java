package product.view;

import java.util.List;

import product.model.vo.Product;

public class UpdateInfoMenu extends ProductMenu{

	public void subMenu(Product product) {
		String menu = "***** 상품정보변경메뉴 *****\n"
				+ "1. 상품명변경\n"
				+ "2. 가격변경\n"
				+ "3. 설명변경\n"
				+ "9. 돌아가기\n"
				+ "------------------------------------- \n"
				+ "입력 : ";
		while(true) {
			System.out.print(menu);
			String choice = sc.next();
			int result = 0;
			
			switch(choice) {
			//상품명 변경
			case "1" :
				System.out.print("변경할 상품명 입력 : ");
				String productName = sc.next();
				product.setProductName(productName);
				result = productController.updateInfo(product);
				display("상품명 변경",result);
				System.out.println(product);
				break;
			//가격 변경
			case "2" :
				System.out.print("변경할 가격 입력 : ");
				int price = sc.nextInt();
				product.setPrice(price);
				result = productController.updateInfo(product);
				display("가격 변경",result);
				System.out.println(product);
				break;
			//설명 변경
			case "3" :
				System.out.print("설명 : ");
				sc.nextLine();
				String description = sc.nextLine();
				product.setDescription(description);
				result = productController.updateInfo(product);
				display("설명 변경",result);
				System.out.println(product);
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
}
