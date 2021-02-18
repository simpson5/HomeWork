package product.controller;

import java.util.List;

import product.model.exception.ProductException;
import product.model.service.ProductService;
import product.model.vo.Product;
import product.model.vo.ProductIO;
import product.view.ProductMenu;

public class ProductController {
	private ProductService productService = new ProductService();
	private List<Product> list = null;
	private Product product = null;
	private int result = 0;
	
	//전체 조회
	public List<Product> selectAll() {
		try {
			list = productService.selectAll(); 
		} catch(ProductException e) {
			new ProductMenu().displayErr(e.getMessage());
		}
		return list;
	}

	//아이디 조회
	public Product selectId(String productId) {
		try {
			product = productService.selectId(productId);
		} catch(ProductException e) {
			new ProductMenu().displayErr(e.getMessage());
		}
		return product;
	}

	//상품명 조회
	public List<Product> selectName(String productName) {
		try {
			list = productService.selectName(productName);
		} catch(ProductException e) {
			new ProductMenu().displayErr(e.getMessage());
		}
		return list;
	}

	//상품 추가
	public int inputProduct(Product product) {
		try {
			result = productService.inputProduct(product);
		} catch(ProductException e) {
			new ProductMenu().displayErr(e.getMessage());
		}
		return result;
	}

	//상품 정보 변경
	public int updateInfo(Product product) {
		try {
			result = productService.updateInfo(product);
		} catch(ProductException e) {
			new ProductMenu().displayErr(e.getMessage());
		}
		return result;
	}

	// 입출고 내역 조회
	public List<Product> IOselectAll() {
		try {
			list = productService.IOselectAll(); 
		} catch(ProductException e) {
			new ProductMenu().displayErr(e.getMessage());
		}
		return list;
	}

	// 입출고 입력
	public int inputProductIO(ProductIO productIO) {
		try {
			result = productService.inputProductIO(productIO);
		} catch(ProductException e) {
			new ProductMenu().displayErr(e.getMessage());
		}
		return result;
	}

	// 상품 삭제
	public int deletProduct(Product product) {
		try {
			result = productService.deletProduct(product);
		} catch(ProductException e) {
			new ProductMenu().displayErr(e.getMessage());
		}
		return result;
	}

}
