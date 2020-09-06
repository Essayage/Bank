package com.bank.entity;

import java.text.SimpleDateFormat;

public class Admin {
	private int aNo;// 管理员编号
	private String aName;
	private String password;
	private String sex;

	public Admin() {
		super();
	}

	public Admin(String aName, String password, String sex) {
		super();
		this.aName = aName;
		this.password = password;
		this.sex = sex;
	}

	public Admin(int aNo, String aName, String password, String sex) {
		super();
		this.aNo = aNo;
		this.aName = aName;
		this.password = password;
		this.sex = sex;
	}

	public int getaNo() {
		return aNo;
	}

	public void setaNo(int aNo) {
		this.aNo = aNo;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "管理员编号: " + aNo + ", 管理员姓名: " + aName + ", 管理员密码: " + password + ", 管理员性别: " + sex;
	}
}
