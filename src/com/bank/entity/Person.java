package com.bank.entity;

public class Person implements Comparable<Person> {
	private String qNo; // 排队号
	private int cNo; // 用户卡号
	private int userId; // 顺序号，3位
	private String type; // 用户类型，为vip或者common
	private String businessType; // 业务类型：1、2、3

	public Person() {
		super();
	}

	public Person(int cNo, int userId, String type, String businessType) {
		super();
		this.cNo = cNo;
		this.userId = userId;
		this.type = type;
		this.businessType = businessType;
	}

	public Person(String qNo, int cNo, int userId, String type, String businessType) {
		super();
		this.qNo = qNo;
		this.cNo = cNo;
		this.userId = userId;
		this.type = type;
		this.businessType = businessType;
	}

	public String getqNo() {
		return qNo;
	}

	public void setqNo(String qNo) {
		this.qNo = qNo;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getbusinessType() {
		return businessType;
	}

	public void setbusinessType(String businessType) {
		this.businessType = businessType;
	}

	@Override
	public int compareTo(Person per) {
		if ((this.type.equals("VIP") && !per.type.equals("VIP")) || (this.type.equals(per.type)))
			return 1;
		else
			return -1;
	}

	@Override
	public String toString() {
		return "排队号: " + qNo + ", 用户卡号: " + cNo + ", 次序号: " + userId + ", 用户类型：" + type + ", 业务类型: " + businessType;
	}
}
