package com.bank.util;

import java.util.List;

import com.bank.dao.UserDao;
import com.bank.dao.UserDaoImp;
import com.bank.entity.User;

public class GetUserMesg {
	String idNumber = null;

	public GetUserMesg() {

	}

	public static String IsVip(String keyword) {
		UserDao userDao = new UserDaoImp();
		// UserService userService = new UserServiceImp();
		List<User> list = userDao.serachAll(keyword);
		for (int i = 0; i < list.size(); i++) {
			return list.get(i).getType();// person类型为vip，则返回vip，否则此用户不存在，则返回common
		}
		return "common";
	}

	public static int getCno(String keyword) {// 通过身份证或银行卡或存折卡号获取cno（Id），不存在则-1表示为空
		UserDao userDao = new UserDaoImp();
		List<User> list = userDao.serachAll(keyword);
		for (int i = 0; i < list.size(); i++) {
			return list.get(i).getID();
		}
		return -1;
	}

	public static void main(String[] args) {
		// System.out.println(IsVip("100964569390"));
		System.out.println(getCno("201214842674"));
	}

}
