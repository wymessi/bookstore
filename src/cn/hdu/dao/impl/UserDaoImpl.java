package cn.hdu.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;





import cn.hdu.dao.UserDao;
import cn.hdu.domain.User;
import cn.hdu.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
	public void addUser(User user) {
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql = "INSERT INTO user(id,username,password,phone,cellphone,address,email) VALUES(?,?,?,?,?,?,?)";
			Object params[] = { user.getId(), user.getUsername(), user.getPassword(),
					user.getPhone(), user.getCellphone(), user.getAddress(),
					user.getEmail() };
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public User findUser(String id){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql ="SELECT * FROM user WHERE id=?";
			User user=qr.query(sql, new BeanHandler(User.class),id);
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public User UserLogin(String username,String password){
		try {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDatasource());
			String sql ="SELECT * FROM user WHERE username=? and password=?";
			Object params[]={username,password};
			User user=qr.query(sql, new BeanHandler(User.class),params);
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
