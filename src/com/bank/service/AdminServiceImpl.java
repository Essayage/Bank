package com.bank.service;

import java.util.List;

import com.bank.dao.AdminDao;
import com.bank.dao.AdminDaoImpl;
import com.bank.entity.Admin;

public class AdminServiceImpl implements AdminService {
	private AdminDao admindao;

	public AdminServiceImpl() {// 构造方法
		this.admindao = new AdminDaoImpl();
	}

	@Override
	public int saveAdmin(Admin admin) {
		if (admin != null) {
			return admindao.save(admin);
		}
		return -1;
	}

	@Override
	public int deleteAdmin(int Ano) {
		Admin admin = this.getAdmin(Ano);
		if (admin != null) {
			return this.admindao.delete(Ano);
		}
		return -1;
	}

	@Override
	public Admin getAdmin(int Ano) {
		return this.admindao.searchByAno(Ano);
	}

	@Override
	public int updateAdmin(Admin admin) {
		Admin admin1 = this.admindao.searchByAno(admin.getaNo());
		if (admin1 != null) {
			return this.admindao.update(admin);
		}
		return -1;
	}

	@Override
	public List<Admin> searchAll(String keyword) {
		if (keyword == null || "".equals(keyword.trim())) {
			keyword = "";
		}
		return this.admindao.serachAll(keyword);
	}

}
