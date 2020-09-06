package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.entity.Admin;
import com.bank.util.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public int save(Admin admin) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into admin(Ano,Aname,Password,Sex) values(?,?,?,?)";

		try {
			conn = DBUtil.getConnection(); // 获取数据库连接
			pstmt = conn.prepareStatement(sql); // 得到数据库操作对象
			pstmt.setInt(1, admin.getaNo()); // 设置参数
			pstmt.setString(2, admin.getaName());
			pstmt.setString(3, admin.getPassword());
			pstmt.setString(4, admin.getSex());

			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Dao数据保存失败!");
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pstmt, conn);
		}
		return i;
	}

	@Override
	public int delete(int ano) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from admin where Ano =?";
		try {
			conn = DBUtil.getConnection(); // 获取数据库连接
			pstmt = conn.prepareStatement(sql); // 得到数据库操作对象
			pstmt.setInt(1, ano);
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Dao数据删除失败!");
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pstmt, conn);
		}
		return i;
	}

	@Override
	public int update(Admin admin) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update admin set Aname=?,Password=?,Sex=? where Ano=?";
		try {
			conn = DBUtil.getConnection(); // 获取数据库连接
			pstmt = conn.prepareStatement(sql); // 得到数据库操作对象
			pstmt.setString(1, admin.getaName());
			pstmt.setString(2, admin.getPassword());
			pstmt.setString(3, admin.getSex());
			pstmt.setInt(4, admin.getaNo());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Dao数据修改失败!");
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pstmt, conn);
		}
		return i;
	}

	@Override
	public Admin searchByAno(int ano) {
		Admin admin = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select Aname,Password,Sex from admin where Ano=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ano); // 设置参数
			rs = pstmt.executeQuery(); // 执行查询
			while (rs.next()) { // 分析查询的结果集
				String Aname = rs.getString("Aname");
				String Password = rs.getString("Password");
				String Sex = rs.getString("Sex");

				admin = new Admin(ano, Aname, Password, Sex);
			}
		} catch (Exception e) {
			System.out.println("Dao根据ano查询失败!");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return admin;
	}

	@Override
	public List<Admin> serachAll(String keyword) {
		List<Admin> list = new ArrayList<Admin>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from admin where Ano like ? or  Aname like ? or Password like ? or Sex like ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int Ano = rs.getInt("Ano");
				String Aname = rs.getString("Aname"); // rs.getString(2);
				String Password = rs.getString("Password");
				String Sex = rs.getString("Sex");
				list.add(new Admin(Ano, Aname, Password, Sex));
			}
		} catch (Exception e) {
			System.out.println("Dao查询关键字失败");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	// 测试
	public static void main(String[] args) {
		saveAdmin();
		// updateAdmin();
		// deleteAdmin();
		// searchByAno();
		searchAllAdmin();
	}

	private static void deleteAdmin() {
		AdminDao admindao = new AdminDaoImpl();
		admindao.delete(1);
	}

	private static void updateAdmin() {
		AdminDao admindao = new AdminDaoImpl();
		Admin admin = new Admin(1, "张三", "123456", "女");
		admindao.update(admin);
	}

	private static void searchByAno() {
		AdminDao admindao = new AdminDaoImpl();
		Admin admin = admindao.searchByAno(1);
		System.out.println(admin);
	}

	private static void searchAllAdmin() {
		AdminDao admindao = new AdminDaoImpl();
		List<Admin> list = admindao.serachAll("1");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void saveAdmin() {
		AdminDao admindao = new AdminDaoImpl();
		Admin admin = new Admin(1, "zhangsan", "123", "男");
		int i = admindao.save(admin);
		if (i > 0) {
			System.out.println("dao的数据保存成功");
		} else {
			System.out.println("dao的数据保存失败");
		}
	}
}
