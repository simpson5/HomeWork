package product.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import product.model.exception.ProductException;
import product.model.vo.Product;
import product.model.vo.ProductIO;

public class ProductrDao {
	
	private Properties prop = new Properties();
	
	public ProductrDao() {
		String fileName = "resources/member-query.properties";
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 전체 조회
	public List<Product> selectAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAll");
		List<Product> list = null;

		try {
			//3. PreparedStatement 객체 생성 (미완성 쿼리)
			//3.1 ? 값 대임
			pstmt = conn.prepareStatement(sql);
			//4. 실행 : DML(executeUpdate) -> int, DQL(excuteQuery) -> ResultSet
			rset = pstmt.executeQuery();
			//4.1 ResultSet -> Java 객체 옮겨담기
			list = new ArrayList<>();
			while(rset.next()) {
				String productId = rset.getString("product_id");
				String productName = rset.getString("product_name");
				int price= rset.getInt("price");
				String description = rset.getString("description");
				int stock = rset.getInt("stock");
				Product product = new Product(productId, productName, price, description, stock);
			
				list.add(product);
			}

		} catch (SQLException e) {
			//e.printStackTrace();
			//예외를 전환 : RuntimeException, 의미분명한 커스텀 예외객체로 전환
			throw new ProductException("전체 상품 조회", e);
		} finally {
			//5. 자원반납(생성역순 rset - pstmt)
			close(rset);
			close(pstmt);
		}
		return list;
	}

	// 아이디 조회
	public Product selectId(Connection conn, String productId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectId");
		Product product = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				productId = rset.getString("product_id");
				String productName = rset.getString("product_name");
				int price= rset.getInt("price");
				String description = rset.getString("description");
				int stock = rset.getInt("stock");
				product = new Product(productId, productName, price, description, stock);
			}
		} catch (SQLException e) {
			throw new ProductException("상품 아이디 조회", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return product;
	}

	//상품명 조회
	public List<Product> selectName(Connection conn, String productName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectName");
		List<Product> list = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + productName + "%");
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rset.next()) {
				String productId = rset.getString("product_id");
				productName = rset.getString("product_name");
				int price= rset.getInt("price");
				String description = rset.getString("description");
				int stock = rset.getInt("stock");
				Product product = new Product(productId, productName, price, description, stock);
			
				list.add(product);
			}

		} catch (SQLException e) {
			throw new ProductException("상품 이름 조회", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	// 상품 추가
	public int inputProduct(Connection conn, Product product) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("inputProduct");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductId());
			pstmt.setString(2, product.getProductName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new ProductException("상품 추가", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 상품 정보 변경
	public int updateInfo(Connection conn, Product product) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateInfo");
		int result = 0;
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getDescription());
			pstmt.setString(4, product.getProductId());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new ProductException("상품 정보 변경", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 입출고 정보 조회
	public List<Product> IOselectAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("IOselectAll");
		List<Product> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rset.next()) {
				int ioNo = rset.getInt("io_no");
				String productId = rset.getString("product_id");
				Date ioDate = rset.getDate("iodate");
				int amount = rset.getInt("amount");
				String status = rset.getString("status");
				ProductIO productIO = new ProductIO(ioNo, productId, ioDate, amount, status);
			
				list.add(productIO);
			}
		} catch (SQLException e) {
			throw new ProductException("입출고 정보 조회", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	// 상품 입고
	public int inputProductIO(Connection conn, ProductIO productIO) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("inputProductIO");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productIO.getProductId());
			pstmt.setInt(2, productIO.getAmount());
			pstmt.setString(3, productIO.getStatus());
			result = pstmt.executeUpdate();
			
			//입출고 오류 검사
			errorIO(conn, productIO.getProductId());
		} catch (SQLException e) {
			throw new ProductException("상품 입출고", e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 상품 삭제
	public int deletProduct(Connection conn, Product product) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deletProduct");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new ProductException("상품 삭제", e);
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//입출고 오류 검사
	public void errorIO(Connection conn, String productId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("IOselectOne");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productId);
			rset = pstmt.executeQuery();
			
			// 잔고가 0보다 작을시 오류를 던짐
			while(rset.next()) {
				if(rset.getInt("stock") < 0) {
					throw new ProductException("잔고가 마이너스 입니다.");
				}
			}
		} catch (SQLException e) {
			throw new ProductException("입출고 오류 검사", e);
		} finally {
			close(rset);
			close(pstmt);
		}
	}
}
