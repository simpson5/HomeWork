package product.model.vo;

import java.sql.Date;

public class ProductIO extends Product {
	private int ioNo;
	private String productId;
	private Date ioDate;
	private int amount;
	private String status;
	
	public ProductIO() {
	}
	
	public ProductIO(int ioNo, String productId, Date ioDate, int amount, String status) {
		this.ioNo = ioNo;
		this.productId = productId;
		this.ioDate = ioDate;
		this.amount = amount;
		this.status = status;
	}

	public ProductIO(String productId, int amount, String status) {
		this.productId = productId;
		this.amount = amount;
		this.status = status;
	}

	public int getIoNo() {
		return ioNo;
	}
	public void setIoNo(int ioNo) {
		this.ioNo = ioNo;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Date getIoDate() {
		return ioDate;
	}
	public void setIoDate(Date ioDate) {
		this.ioDate = ioDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ProductIO [ioNo=" + ioNo + ", productId=" + productId + ", ioDate=" + ioDate + ", amount=" + amount
				+ ", status=" + status + "]";
	}
}
