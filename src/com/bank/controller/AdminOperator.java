package com.bank.controller;

import java.util.List;

import com.bank.dao.AdminDao;
import com.bank.dao.AdminDaoImpl;
import com.bank.entity.Admin;
import com.bank.service.AdminService;
import com.bank.service.AdminServiceImpl;

public class AdminOperator {
	private static AdminService adminService = new AdminServiceImpl();

	public static boolean match(String aNo, String password) {// ∆•≈‰’À∫≈√‹¬Î
		AdminDao admindao = new AdminDaoImpl();
		Admin admin = admindao.searchByAno(Integer.parseInt(aNo));
		System.out.println(admin);
		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// System.out.println(match("1","123"));
	}
}
