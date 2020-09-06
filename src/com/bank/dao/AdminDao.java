package com.bank.dao;

import java.util.List;

import com.bank.entity.Admin;

public interface AdminDao {
	// 增加管理员
	int save(Admin admin);

	// 删除管理员
	int delete(int ano);

	// 修改信息
	int update(Admin admin);

	// 查询管理员信息
	Admin searchByAno(int ano);

	// 查询关键字
	List<Admin> serachAll(String keyword);
}
