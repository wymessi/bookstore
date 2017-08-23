package cn.hdu.dao;

import java.util.List;

import cn.hdu.domain.Book;

public interface BookDao {

	void addBook(Book book);

	Book findBook(String id);

	List<Book> getPageData(int startIndex, int pageSize);

	int getTotalRecord();

	int getTotalRecord(String category_id);

	List<Book> getPageData(int startIndex, int pageSize, String category_id);

}