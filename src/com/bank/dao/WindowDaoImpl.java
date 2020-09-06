package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.entity.Person;
import com.bank.entity.User;
import com.bank.util.DBUtil;

public class WindowDaoImpl implements WindowDao {

	@Override
	public int updateWindow(String[] window) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update windows set window1 = ?,window2=?,window3=?";

		try {
			conn = DBUtil.getConnection();// 获取数据
			pstmt = conn.prepareStatement(sql);// 得到数据
			pstmt.setString(1, window[0]);
			pstmt.setString(2, window[1]);
			pstmt.setString(3, window[2]);

			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("windowDao数据修改失败！");
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pstmt, conn);
		}

		return i;
	}

	@Override
	public String[] getWindows() {// 从数据库中读取保存的窗口参数
		String[] windows = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		String sql = "select * from windows";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

//			if(rs.next()!=true) {
//				this.saveWindows();
//			}

			while (rs.next()) {
				String window1 = rs.getString("window1");
				String window2 = rs.getString("window2");
				String window3 = rs.getString("window3");
				String[] str = { window1, window2, window3 };
				windows = str;
			}
		} catch (Exception e) {
			System.out.println("windowDao查询关键字失败");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return windows;
	}

	public static int saveWindows(int num) {
		int i = -1;
		if (num == 1) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "insert into windows(window1,window2,window3) " + "values(?,?,?)";

			try {
				conn = DBUtil.getConnection(); // 获取数据库连接
				pstmt = conn.prepareStatement(sql); // 得到数据库操作对象
				pstmt.setString(1, "个人业务"); // 设置参数
				pstmt.setString(2, "对公业务");
				pstmt.setString(3, "特殊业务");

				i = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("windowDao数据保存失败!");
				e.printStackTrace();
			} finally {
				DBUtil.close(null, pstmt, conn);
			}
		}
		return i;
	}

	public static void main(String[] args) {
		//saveWindows(1);
		WindowDaoImpl win = new WindowDaoImpl();
		for (int i = 0; i < 3; i++) {
			System.out.println(win.getWindows()[i]);
		}
	}

}
