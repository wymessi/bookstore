package cn.hdu.dao.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.hdu.dao.OrderDao;
import cn.hdu.domain.Book;
import cn.hdu.domain.Order;
import cn.hdu.domain.OrderItem;
import cn.hdu.domain.User;
import cn.hdu.utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {
	public void addOrder(Order order) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "INSERT INTO orders(id,ordertime,price,state,user_id) VALUES(?,?,?,?,?)";
			Object params[] = { order.getId(), order.getorderTime(),
					order.getPrice(), order.isState(), order.getUser().getId() };
			qr.update(sql, params);

			Set<OrderItem> set = order.getOrderitems();
			for (OrderItem item : set) {
				sql = "INSERT INTO orderitem(id,quantity,price,order_id,book_id) VALUES(?,?,?,?,?)";
				params = new Object[] { item.getId(), item.getQuantity(),
						item.getPrice(), order.getId(), item.getBook().getId() };
				qr.update(sql, params);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Order findOrder(String order_id) {
		try {
			// 1.找出订单的基本信息
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "SELECT * FROM orders WHERE id=?";
			Order order = qr.query(sql, new BeanHandler(Order.class), order_id);
			// 2.找出订单中所有订单项
			sql = "SELECT * FROM orderitem WHERE order_id=?";
			List<OrderItem> list = qr.query(sql, new BeanListHandler(
					OrderItem.class), order_id);
			for(OrderItem item : list){
				sql = "SELECT book.* FROM orderitem,book where orderitem.id=? and orderitem.book_id=book.id";
				Book book =  qr.query(sql, item.getId(), new BeanHandler(Book.class));
				item.setBook(book);
			}
			order.getOrderitems().addAll(list);
			// 3.订单属于哪个用户
			sql = "select user.* from orders,user where orders.id=? and orders.user_id=user.id";
			User user = qr.query(sql, new BeanHandler(User.class), order_id);
			order.setUser(user);
			return order;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Order> listAllOrder(boolean state) {
		try {

			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "SELECT * FROM orders WHERE state=?";
			List<Order> list = qr.query(sql, new BeanListHandler(Order.class),state);

			for (Order o : list) {
				sql = "SELECT user.* FROM user,orders WHERE orders.id=? AND orders.user_id=user.id";
				User user = qr.query(sql, new BeanHandler(User.class),o.getId());
				o.setUser(user);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateOrder(Order order) {

		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql="UPDATE orders SET state=? WHERE id=?";
			qr.update(sql, new Object[]{order.isState(),order.getId()});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Order> listUserOrder(User user) {
		try {

			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "SELECT * FROM orders WHERE user_id=?";
			List<Order> list = qr.query(sql, new BeanListHandler(Order.class),user.getId());

			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
