package com.bank.controller;

import com.bank.entity.User;
import com.bank.service.UserService;
import com.bank.service.UserServiceImp;
import com.bank.util.Uuid;

public class UserOperator {
	private static UserService service = new UserServiceImp();

	// 从界面获取用户信息并将其存入数据库(开户)

	public static void saveUser(String name, String idno, String password, String type) {
		// 1.创建一个用户并初始化其属性

		int cno = Uuid.uuidInt();
		int amount = 0;
		String card = Uuid.uuidCard();
		String pno = Uuid.uuidPno();

		User user = new User(cno, name, password, type, amount, card, idno, pno);
		// 2.调用服务层，将其保存到数据库中

		int i = service.saveUser(user);

		if (i > 0) {
			System.out.println("用户的信息保存成功！(" + user + ")");
		} else {
			System.out.println("用户的信息保存失败！");
		}
	}

	// 查询用户信息
	public static User find(int cno) {
		return service.findUser(cno);
	}

	// 根据身份证号查询用户信息
	public static User findUserID(String ID) {
		return service.findUserID(ID);
	}

	// 存款
	public static void deposit(int cno, int num) {
		// 1.从服务层获取用户信息

		User user = service.findUser(cno);

		// 2.计算总金额
		int amount = 0;
		if (user != null) {
			amount = user.getAmount() + num;
			System.out.println(amount);
		}

		// 3.调用服务层，存入数据库
		service.updateAmount(cno, amount);
	}

	// 取款
	public static int withdraw(int cno, int num) {
		// 1.从服务层获取用户信息

		User user = service.findUser(cno);

		// 2.计算总金额
		int amount = 0;
		if (user != null) {
			amount = user.getAmount() - num;

			if (amount < 0) {
				return -1;
			}
		}

		// 3.调用服务层，存入数据库
		service.updateAmount(cno, amount);

		return 1;
	}

	// 转账
	public static int transfer(int cno1, int cno2, int num) {
		User user1 = service.findUser(cno1);
		User user2 = service.findUser(cno2);

		int amount1 = 0;
		int amount2 = 0;
		if (user2 != null) {
			amount1 = user1.getAmount() - num;
			amount2 = user2.getAmount() + num;
			if (amount1 < 0) {
				return -1;
			}
		}

		service.updateAmount(cno1, amount1);
		service.updateAmount(cno2, amount2);

		return 1;
	}

	// 修改密码
	public static void updatePassword(int cno, String password) {
		User user = service.findUser(cno);

		if (user != null) {
			service.updatePassword(cno, password);
		}
	}

	public static int  verification(int cno,String password) {
		User user = service.findUser(cno);
		if (user != null) {
			if (password.equals(user.getPassword())) {
				return 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		saveUser("cxk", "3261362", "456678", "vip");
		// deposit(2, 100000);
		// withdraw(2, 1000);
		// transfer(101189, 2, 900);
		// updatePassword(2, "huiaiuse");
	}

}
