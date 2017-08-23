package cn.hdu.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.hdu.dao.CategoryDao;
import cn.hdu.domain.Category;
import cn.hdu.utils.JdbcUtils;

public class CategoryDaoImpl implements CategoryDao {

	public void addCategory(Category category) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "INSERT INTO category(id,name,description) VALUES(?,?,?)";
			Object params[] = { category.getId(), category.getName(),
					category.getDescription() };
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public Category findCategory(String id){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "select * from category where id=?";
			return (Category) runner.query(sql, id, new BeanHandler(Category.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public List<Category> listAllCategory() {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql="SELECT * FROM category";
			List<Category> list=qr.query(sql, new BeanListHandler(Category.class));
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
