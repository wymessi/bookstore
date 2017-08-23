package cn.hdu.dao;

import java.util.List;

import cn.hdu.domain.Order;
import cn.hdu.domain.User;

public interface OrderDao {

	void addOrder(Order order);

	Order findOrder(String order_id);

	List<Order> listAllOrder(boolean state);

	void updateOrder(Order order);

	List<Order> listUserOrder(User user);
}