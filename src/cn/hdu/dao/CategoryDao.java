package cn.hdu.dao;

import java.util.List;

import cn.hdu.domain.Category;

public interface CategoryDao {

	void addCategory(Category category);

	List<Category> listAllCategory();
	
	Category findCategory(String id);

}