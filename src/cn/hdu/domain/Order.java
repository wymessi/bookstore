package cn.hdu.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

	private String id;
	private Date orderTime;
	private double price;
	private boolean state;
	
	private User user;  //user_id
	private Set<OrderItem> orderitems= new HashSet();  //orderitem order_id
	
	
	public Set<OrderItem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(Set<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	public Date getorderTime() {
		return orderTime;
	}
	public void setorderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
