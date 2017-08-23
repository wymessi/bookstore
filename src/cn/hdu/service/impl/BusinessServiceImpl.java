package cn.hdu.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.hdu.dao.BookDao;
import cn.hdu.dao.CategoryDao;
import cn.hdu.dao.OrderDao;
import cn.hdu.dao.UserDao;
import cn.hdu.domain.Book;
import cn.hdu.domain.Cart;
import cn.hdu.domain.CartItem;
import cn.hdu.domain.Category;
import cn.hdu.domain.Order;
import cn.hdu.domain.OrderItem;
import cn.hdu.domain.Page;
import cn.hdu.domain.User;
import cn.hdu.utils.DaoFactory;
import cn.hdu.utils.WebUtils;

public class BusinessServiceImpl {

	CategoryDao cdao = DaoFactory.getInstance().createDao(
			"cn.hdu.dao.impl.CategoryDaoImpl", CategoryDao.class);
	BookDao bdao = DaoFactory.getInstance().createDao(
			"cn.hdu.dao.impl.BookDaoImpl", BookDao.class);
	UserDao udao=DaoFactory.getInstance().createDao(
			"cn.hdu.dao.impl.UserDaoImpl", UserDao.class);
	OrderDao odao=DaoFactory.getInstance().createDao(
			"cn.hdu.dao.impl.OrderDaoImpl", OrderDao.class);
	public void addCategory(Category category) {
		cdao.addCategory(category);
	}

	public List<Category> listAllCategory() {
		return cdao.listAllCategory();
	}
	
	public Category findCategory(String id){
		return cdao.findCategory(id);
	}
	
	public void addBook(Book book){
		bdao.addBook(book);
	}
	
	public Book findBook(String id){
		return bdao.findBook(id);
	}
	
	public Page getPage(String pageNum){
		int totalRecord=bdao.getTotalRecord();
		Page page = null;
		if(pageNum==null){
			page = new Page(1,totalRecord);
		}else{
			page = new Page(Integer.parseInt(pageNum),totalRecord);
		}
		List<Book> list=bdao.getPageData(page.getStartIndex(), page.getPageSize());
		page.setList(list);
		return page;
	}
	
	public Page getPage(String pageNum,String category_id){
		int totalRecord=bdao.getTotalRecord(category_id);
		Page page = null;
		if(pageNum==null){
			page = new Page(1,totalRecord);
		}else{
			page = new Page(Integer.parseInt(pageNum),totalRecord);
		}
		List<Book> list=bdao.getPageData(page.getStartIndex(), page.getPageSize(),category_id);
		page.setList(list);
		return page;
	}

	public void buyBook(Cart cart, Book book) {
		cart.addBook(book);
	}
	
	public void register(User user){
		udao.addUser(user);
	}
	public User login(String username,String password){
		return udao.UserLogin(username, password);
	}
	
	public User findUser(String id){
		return udao.findUser(id);
	}

	public void createOrder(User user, Cart cart) {
		Order order=new Order();
		order.setId(WebUtils.makeId());
		order.setorderTime(new Date());
		order.setUser(user);
		order.setState(false);
		order.setPrice(cart.getPrice());
		for(Map.Entry<String, CartItem> me:cart.getMap().entrySet()){
			
			CartItem citem=me.getValue();
			OrderItem oitem=new OrderItem();
			oitem.setBook(citem.getBook());
			oitem.setId(WebUtils.makeId());
			oitem.setQuantity(citem.getNumber());
			oitem.setPrice(citem.getPrice());
			order.getOrderitems().add(oitem);
		}
		odao.addOrder(order);
	}

	public List<Order> listOrder(String state) {
		
		return odao.listAllOrder(Boolean.parseBoolean(state));
	}

	public Order findOrder(String order_id) {
		
		return odao.findOrder(order_id);
	}

	public void updateOrder(String order_id) {
		Order order=odao.findOrder(order_id);
		order.setState(true);
		odao.updateOrder(order);
	}

	public List<Order> listAllOrder(User user) {
		return odao.listUserOrder(user);
		
	}
}
