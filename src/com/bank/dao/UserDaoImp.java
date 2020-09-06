package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.entity.User;
import com.bank.util.DBUtil;

public class UserDaoImp implements UserDao {

	@Override
	public int save(User user) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into user(cno,cname,password,type,amount,card,idno,pno)" + "values(?,?,?,?,?,?,?,?)";

		try {
			conn = DBUtil.getConnection();// 获取数据
			pstmt = conn.prepareStatement(sql);// 得到数据
			pstmt.setInt(1, user.getID());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getType());
			pstmt.setInt(5, user.getAmount());
			pstmt.setString(6, user.getCardNo());
			pstmt.setString(7, user.getIDNo());
			pstmt.setString(8, user.getPno());

			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("数据保存失败！");
			e.printStackTrace();

		} finally {
			DBUtil.close(null, pstmt, conn);
		}

		return i;
	}

	@Override
	public int delete(int cno) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from user where cno = ?";

		try {
			conn = DBUtil.getConnection();// 获取数据
			pstmt = conn.prepareStatement(sql);// 得到数据
			pstmt.setInt(1, cno);// 设置参数

			i = pstmt.executeUpdate();// 执行删除操作
		} catch (Exception e) {
			System.out.println("数据删除失败！");
			e.printStackTrace();

		} finally {
			DBUtil.close(null, pstmt, conn);
		}

		return i;
	}

	@Override
	public int updateAmount(int cno, int amount) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		User user = findByCno(cno);
		if (user == null)
			return -1;
		String sql = "update user set amount = ? where cno = ?";

		try {
			conn = DBUtil.getConnection();// 获取数据
			pstmt = conn.prepareStatement(sql);// 得到数据
			pstmt.setInt(1, amount);
			pstmt.setInt(2, cno);

			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("数据修改失败！");
			e.printStackTrace();

		} finally {
			DBUtil.close(null, pstmt, conn);
		}

		return i;
	}

	@Override
	public User findByCno(int cno) {
		User user = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select cno,cname,password,type,amount,card,idno,pno from user where cno = ?";

		try {
			conn = DBUtil.getConnection();// 获取数据
			pstmt = conn.prepareStatement(sql);// 得到数据
			pstmt.setInt(1, cno);// 设置参数

			rs = pstmt.executeQuery();// 执行查询
			while (rs.next()) {// 分析查询的结果集
				String name = rs.getString(2);
				String password = rs.getString(3);
				String type = rs.getString(4);
				int amount = rs.getInt(5);
				String card = rs.getString(6);
				String idno = rs.getString(7);
				String pno = rs.getString(8);

				user = new User(cno, name, password, type, amount, card, idno, pno);
			}
		} catch (Exception e) {
			System.out.println("根据id查询失败！");
			e.printStackTrace();

		} finally {
			DBUtil.close(rs, pstmt, conn);
		}

		return user;
	}

	@Override
	public int updatePassword(int cno, String password) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		User user = findByCno(cno);
		if (user == null)
			return -1;
		String sql = "update user set password = ? where cno = ?";

		try {
			conn = DBUtil.getConnection();// 获取数据
			pstmt = conn.prepareStatement(sql);// 得到数据
			pstmt.setString(1, password);
			pstmt.setInt(2, cno);

			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("数据修改失败！");
			e.printStackTrace();

		} finally {
			DBUtil.close(null, pstmt, conn);
		}

		return i;
	}

	@Override
	public User findByID(String ID) {
		User user = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select cno,cname,password,type,amount,card,idno,pno from user where IDno = ?";

		try {
			conn = DBUtil.getConnection();// 获取数据
			pstmt = conn.prepareStatement(sql);// 得到数据
			pstmt.setString(1, ID);// 设置参数

			rs = pstmt.executeQuery();// 执行查询
			while (rs.next()) {// 分析查询的结果集
				int cno = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String type = rs.getString(4);
				int amount = rs.getInt(5);
				String card = rs.getString(6);

				String pno = rs.getString(8);

				user = new User(cno, name, password, type, amount, card, ID, pno);
			}
		} catch (Exception e) {
			System.out.println("根据id查询失败！");
			e.printStackTrace();

		} finally {
			DBUtil.close(rs, pstmt, conn);
		}

		return user;
	}

	public static void main(String[] args) {
		// save();
		// find();
		// updateAmount();
		// updatePassword();
		// delete();
		// searchAllUser();
	}

	private static void delete() {
		UserDao dao = new UserDaoImp();
		int i = dao.delete(1);
		if (i > 0) {
			System.out.println("数据删除成功");
		} else {
			System.out.println("数据删除失败");
		}
	}

	private static void updatePassword() {
		UserDao dao = new UserDaoImp();
		int i = dao.updatePassword(1, "sdaad");
		if (i > 0) {
			System.out.println("数据修改成功");
		} else {
			System.out.println("数据修改失败");
		}
	}

	private static void updateAmount() {
		UserDao dao = new UserDaoImp();
		int i = dao.updateAmount(1, 100);
		if (i > 0) {
			System.out.println("数据修改成功");
		} else {
			System.out.println("数据修改失败");
		}
	}

	private static void find() {
		UserDao dao = new UserDaoImp();
		User user = dao.findByCno(3);
		System.out.println(user);
	}

	private static void save() {
		UserDao dao = new UserDaoImp();
		User user = new User(2, "蔡徐坤", "123456", "v", 100, "654321", "456789", "123789");
		int i = dao.save(user);
		if (i > 0) {
			System.out.println("数据保存成功");
		} else {
			System.out.println("数据保存失败");
		}
	}

	@Override
	public List<User> serachAll(String keyword) {
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user where Card like ? or " + " IDno like ? or Pno like ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int Cno = rs.getInt("Cno");
				String Cname = rs.getString("Cname");
				String Password = rs.getString("Password");
				String Type = rs.getString("Type");
				int Amount = rs.getInt("Amount");
				String Card = rs.getString("Card");
				String IDno = rs.getString("IDno");
				String Pno = rs.getString("Pno");

				list.add(new User(Cno, Cname, Password, Type, Amount, Card, IDno, Pno));
			}
		} catch (Exception e) {
			System.out.println("userDao查询关键字失败");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	private static void searchAllUser() {

		UserDao userDao = new UserDaoImp();
		List<User> list = userDao.serachAll("100964569390");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
