package com.bank.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Input {

	// 从键盘获取非空字符串信息
	public static String getKeyword(String msg) {
		String str = null;
		System.out.println(msg);

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			str = bf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return str.trim();
	}

	// 从键盘获取非空字符串信息
	public static String getString(String msg, String err) {
		String str = null;
		System.out.println(msg);

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// Scanner sc = new Scanner(System.in);
		boolean flag = true;

		try {
			while (flag) {
				str = bf.readLine();
				if (!str.trim().equals("")) {
					flag = false;
				} else {
					System.out.println(err);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {/*
					 * try { bf.close(); } catch (IOException e) { e.printStackTrace(); }
					 */
		}

		return str.trim();
	}

	public static void main(String[] args) {

		String str = Input.getString("请输入", "不能为空！请从新输入");
		System.out.println(str);
		// float price = getData("请输入", "不能为空！请从新输入");
		// System.out.println(price);
		// java.util.Date date = Input.getDate("输入日期(格式为yyyy-mm-dd)", "日期格式错误，请从新输入");
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy年mm月dd日");
		// System.out.println(sdf.format(date));
	}

	// 获取一个浮点数
	public static float getData(String msg, String err) {
		System.out.println(msg);
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		Float data = null;
		while (flag) {
			String str = scanner.nextLine();
			if (str.matches("^\\d+(\\.\\d{1,2})?$")) {
				data = Float.parseFloat(str);
				flag = false;
			} else {
				System.out.println(err);
			}
		}

		return data;
	}

	// 从键盘获取一个整数
	public static int getInt(String msg, String err) {
		System.out.println(msg);
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		int data = -1;
		while (flag) {
			String str = scanner.nextLine();
			if (str.matches("^\\d+$")) {
				data = Integer.parseInt(str);
				flag = false;
			} else {
				System.out.println(err);
			}
		}

		return data;
	}

	public static java.util.Date getDate(String msg, String err) {
		System.out.println(msg);
		java.util.Date date = null;
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		boolean flag = true;
		while (flag) {
			String str = sc.nextLine();
			if (str.matches("\\d{4}-\\d{2}-\\d{2}")) {
				try {
					date = sdf.parse(str);
					flag = false;
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println(err);
			}
		}
		return date;
	}

}
