package com.bank.controller;

import com.bank.service.WindowServiceImpl;

public class WindowsOperator {
	private static WindowServiceImpl windowService = new WindowServiceImpl();
	
	public static int updateWindow(String[] windows) {
		int i=-1;
		i=windowService.updateWindows(windows);
		return i;
	}
	public static String[] getWindow() {//获得数据库中保存的窗口对应的业务类型相关信息
		return windowService.getWindow();
	}
	public static void main(String[] args) {
		for(int i =0;i<3;i++) {
			System.out.println(getWindow()[i]);
		}
	}
	
}
