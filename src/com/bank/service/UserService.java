package com.bank.service;

import com.bank.entity.User;

public interface UserService {
	// 存储用户信息
	int saveUser(User user);

	// 删除用户信息
	int deleteUser(int cno);

	// 修改账户余额
	int updateAmount(int cno, int aamount);

	// 查询账户信息
	User findUser(int cno);

	// 修改用户密码
	int updatePassword(int cno, String password);

	// 根据身份证号查询用户信息
	User findUserID(String ID);

}
