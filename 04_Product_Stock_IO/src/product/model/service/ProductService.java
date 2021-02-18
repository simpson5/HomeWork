package product.model.service;

import java.sql.Connection;
import java.util.List;

import product.model.dao.ProductrDao;
import product.model.vo.Product;
import product.model.vo.ProductIO;

import static common.JDBCTemplate.*;

/**
Service
1. DriverClass등록 (최초 1회)
2. Connection 객체생성 url, user, password
2.1 자동커밋 false 설정
--------- Dao 요청 ----------
6. 트랜잭션 처리 commit / rollback
7. 자원반납(생성역순 conn)

Dao
3. PreparedStatement 객체 생성 (미완성 쿼리)
3.1 ? 값 대임
4. 실행 : DML(executeUpdate) -> int, DQL(excuteQuery) -> ResultSet
4.1 ResultSet -> Java 객체 옮겨담기
5. 자원반납(생성역순 rset - pstmt)
* 
*/

public class ProductService {

	private ProductrDao productrDao = new ProductrDao();

	// 전체 조회
	public List<Product> selectAll() {
		Connection conn = getConnection();
		List<Product> list = productrDao .selectAll(conn);
		close(conn);
		return list;
	}

	// 아이디 조회
	public Product selectId(String productId) {
		Connection conn = getConnection();
		Product product = productrDao .selectId(conn, productId);
		close(conn);
		return product;
	}

	// 상품명 조회
	public List<Product> selectName(String productName) {
		Connection conn = getConnection();
		List<Product> list = productrDao .selectName(conn, productName);
		close(conn);
		return list;
	}

	// 상품 추가
	public int inputProduct(Product product) {
		Connection conn = getConnection();
		int result = productrDao.inputProduct(conn, product);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	// 상품 정보 변경
	public int updateInfo(Product product) {
		Connection conn = getConnection();
		int result = productrDao.updateInfo(conn, product);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	//입출고 정보 조회
	public List<Product> IOselectAll() {
		Connection conn = getConnection();
		List<Product> list = productrDao .IOselectAll(conn);
		close(conn);
		return list;
	}

	//상품 입고
	public int inputProductIO(ProductIO productIO) {
		Connection conn = getConnection();
		int result = productrDao.inputProductIO(conn, productIO);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int deletProduct(Product product) {
		Connection conn = getConnection();
		int result = productrDao.deletProduct(conn, product);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

}
