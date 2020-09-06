package com.bank.entity;

public class User {
	private int ID;
	private String name;
	private String password;
	private String type;
	private int amount;
	private String cardNo;
	private String IDNo;
	private String pno;

	public User(String name, String password, String type, int amount, String cardNo, String iDNo, String pno) {
		super();
		this.name = name;
		this.password = password;
		this.type = type;
		this.amount = amount;
		this.cardNo = cardNo;
		IDNo = iDNo;
		this.pno = pno;
	}

	public User(int iD, String name, String password, String type, int amount, String cardNo, String iDNo, String pno) {
		super();
		ID = iD;
		this.name = name;
		this.password = password;
		this.type = type;
		this.amount = amount;
		this.cardNo = cardNo;
		IDNo = iDNo;
		this.pno = pno;
	}

	public User() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getIDNo() {
		return IDNo;
	}

	public void setIDNo(String iDNo) {
		IDNo = iDNo;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", name=" + name + ", password=" + password + ", type=" + type + ", amount=" + amount
				+ ", cardNo=" + cardNo + ", IDNo=" + IDNo + ", pno=" + pno + "]";
	}
}
