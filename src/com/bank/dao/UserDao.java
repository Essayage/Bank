package com.bank.dao;

import java.util.List;

import com.bank.entity.User;

public interface UserDao {
	// 增加用户信息
	int save(User user);

	// 删除用户信息
	int delete(int cno);

	// 修改金额
	int updateAmount(int cno, int amount);

	// 查询用户信息
	User findByCno(int cno);

	// 修改密码
	int updatePassword(int cno, String password);

	List<User> serachAll(String keyword);

	User findByID(String ID);
}
