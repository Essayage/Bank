package com.bank.service;

import com.bank.dao.WindowDao;
import com.bank.dao.WindowDaoImpl;

public class WindowServiceImpl implements WindowService{
	private WindowDaoImpl winDao=new WindowDaoImpl();//必须要new一个对象，否则是空对象
	
	@Override
	public int updateWindows(String[] windows) {
		int i =-1;
		i=winDao.updateWindow(windows);
		return i;
	}
	@Override
	public String[] getWindow() {
		if(null==winDao.getWindows())
		return null;
		return winDao.getWindows();
	}
	public static void main(String[] args) {
		
		WindowServiceImpl sdf=new WindowServiceImpl();
		String str[] =null;
		str=sdf.getWindow();
		for(int i=0;i<3;i++) {
			System.out.println(str[i]);
		}
	}
}
