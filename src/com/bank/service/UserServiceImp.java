package com.bank.service;

import com.bank.dao.UserDao;
import com.bank.dao.UserDaoImp;
import com.bank.entity.User;

public class UserServiceImp implements UserService {
	private UserDao dao;

	public UserServiceImp() {
		this.dao = new UserDaoImp();
	}

	@Override
	public int saveUser(User user) {
		if (user != null) {
			return this.dao.save(user);
		}
		return -1;
	}

	@Override
	public int deleteUser(int cno) {
		User user = dao.findByCno(cno);
		if (user != null) {
			return this.dao.delete(cno);
		}

		return -1;
	}

	@Override
	public int updateAmount(int cno, int amount) {
		User user = this.dao.findByCno(cno);

		if (user != null) {
			return this.dao.updateAmount(cno, amount);
		}

		return -1;
	}

	@Override
	public User findUser(int cno) {
		return this.dao.findByCno(cno);
	}

	@Override
	public int updatePassword(int cno, String password) {
		User user = this.dao.findByCno(cno);

		if (user != null) {
			return this.dao.updatePassword(cno, password);
		}

		return -1;
	}

	@Override
	public User findUserID(String ID) {
		return this.dao.findByID(ID);
	}

}
