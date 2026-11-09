package fr.insa.ms.PrincipalService.model;

public class Order {
	
	private int orderId;
	private int customerId;
	private int articleId;
	
	public Order() {}
	
	public Order(int orderId, int customerId, int articleId) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.articleId = articleId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
}
