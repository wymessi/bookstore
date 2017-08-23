package cn.hdu.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<String,CartItem> map=new HashMap<String,CartItem>();
	private double price;
	
	public void addBook(Book book){
		CartItem item=map.get(book.getId());
		if(item==null){
			item=new CartItem();
			item.setBook(book);
			item.setNumber(1);
			item.setPrice(book.getPrice());
			map.put(book.getId(), item);
		}else{
			item.setNumber(item.getNumber()+1);
		}
	}
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public double getPrice() {
		double totalPrice=0;
		for(Map.Entry<String, CartItem> me:map.entrySet()){
			totalPrice+=me.getValue().getPrice();
		}
		return totalPrice;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
