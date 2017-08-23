package cn.hdu.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.hdu.dao.BookDao;
import cn.hdu.domain.Book;
import cn.hdu.utils.JdbcUtils;

public class BookDaoImpl implements BookDao {

	public void addBook(Book book) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "INSERT INTO book(id,name,author,price,image,description,category_id) VALUES(?,?,?,?,?,?,?)";
			Object params[] = { book.getId(), book.getName(), book.getAuthor(),
					book.getPrice(), book.getImage(), book.getDescription(),
					book.getCategory_id() };
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Book findBook(String id){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql ="SELECT * FROM book WHERE id=?";
			Book book=qr.query(sql, new BeanHandler(Book.class),id);
			return book;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Book> getPageData(int startIndex,int pageSize){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql ="SELECT * FROM book LIMIT ?,?";
			Object params[]={startIndex,pageSize};
			List<Book> list=qr.query(sql,new BeanListHandler(Book.class),params);
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Book> getPageData(int startIndex,int pageSize,String category_id){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql ="SELECT * FROM book WHERE category_id=? LIMIT ?,?";
			Object params[]={category_id,startIndex,pageSize};
			List<Book> list=qr.query(sql,new BeanListHandler(Book.class),params);
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public int getTotalRecord(){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql ="SELECT COUNT(*) FROM book";
			long totalRecord=qr.query(sql, new ScalarHandler());
			return (int)totalRecord;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public int getTotalRecord(String category_id){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql ="SELECT COUNT(*) FROM book WHERE category_id=?";
			long totalRecord=qr.query(sql, new ScalarHandler(),category_id);
			return (int)totalRecord;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
