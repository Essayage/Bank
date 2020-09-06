package com.bank.service;

import java.util.List;

import com.bank.entity.Admin;

public interface AdminService {
	// 新增存储管理员信息
	int saveAdmin(Admin admin);

	// 根据ano删除管理员
	int deleteAdmin(int Ano);

	// 查询一个管理员
	Admin getAdmin(int Ano);

	// 根据qno更新管理员的信息
	int updateAdmin(Admin admin);

	// 根据传入关键字模糊查询管理员
	List<Admin> searchAll(String keyword);

}
