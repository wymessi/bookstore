package cn.hdu.dao;

import cn.hdu.domain.User;

public interface UserDao {

	void addUser(User user);

	User findUser(String id);

	User UserLogin(String username, String password);

}