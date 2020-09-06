package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.entity.Admin;
import com.bank.entity.Person;
import com.bank.util.DBUtil;

public class PersonDaoImpl implements PersonDao {

	@Override
	public int save(Person person) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into person(Qno,Cno,Userid,type,businessType) " + "values(?,?,?,?,?)";

		try {
			conn = DBUtil.getConnection(); // 获取数据库连接
			pstmt = conn.prepareStatement(sql); // 得到数据库操作对象
			pstmt.setString(1, person.getqNo()); // 设置参数
			pstmt.setInt(2, person.getcNo());
			pstmt.setInt(3, person.getUserId());
			pstmt.setString(4, person.getType());
			pstmt.setString(5, person.getbusinessType());

			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("persongDao数据保存失败!");
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pstmt, conn);
		}

		return i;
	}

	@Override
	public int delete(String qno) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from person where Qno=?";
		try {
			conn = DBUtil.getConnection(); // 获取数据库连接
			pstmt = conn.prepareStatement(sql); // 得到数据库操作对象
			pstmt.setString(1, qno); // 设置参数
			i = pstmt.executeUpdate(); // 执行删除操作
		} catch (Exception e) {
			System.out.println("personDao数据删除失败!");
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pstmt, conn);
		}
		return i;
	}

	@Override
	public int update(Person person) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update person set Cno=?,Userid=?,type=?,businessType=? where Qno=?";

		try {
			conn = DBUtil.getConnection(); // 获取数据库连接
			pstmt = conn.prepareStatement(sql); // 得到数据库操作对象
			pstmt.setInt(1, person.getcNo());
			pstmt.setInt(2, person.getUserId());
			pstmt.setString(3, person.getType());
			pstmt.setString(4, person.getbusinessType());
			pstmt.setString(5, person.getqNo());

			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("personDao数据更新失败!");
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pstmt, conn);
		}
		return i;
	}

	@Override
	public Person searchByQno(String qno) {
		Person person = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select Qno,Cno,Userid,type,businessType " + " from person where Qno=?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qno); // 设置参数
			rs = pstmt.executeQuery(); // 执行查询
			while (rs.next()) { // 分析查询的结果集
				String qno1 = rs.getString("Qno");
				int cno = rs.getInt("Cno");
				int userid = rs.getInt("Userid");
				String type = rs.getString("type");
				String businessType = rs.getString("businessType");

				person = new Person(qno1, cno, userid, type, businessType);
			}
		} catch (Exception e) {
			System.out.println("personDao根据qno查询失败!");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return person;
	}

	@Override
	public List<Person> serachAll(String keyword) {
		List<Person> list = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from person where Qno like ? or "
				+ " Cno like ? or Userid like ? or type like ? or businessType like ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setString(5, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String Qno = rs.getString("Qno");
				int Cno = rs.getInt("Cno"); // rs.getString(2);
				int userid = rs.getInt("Userid");
				String type = rs.getString("type");
				String businessType = rs.getString("businessType");

				list.add(new Person(Qno, Cno, userid, type, businessType));
			}
		} catch (Exception e) {
			System.out.println("personDao查询关键字失败");
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	public static void main(String[] args) {
		// savePerson();
		// searchByQno();
		// updatePerson();
		// deletePerson();
		deleteAll();
		searchAllPerson();

	}

	private static void searchAllPerson() {
		PersonDao persondao = new PersonDaoImpl();
		List<Person> list = persondao.serachAll("");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void savePerson() {
		PersonDao persondao = new PersonDaoImpl();
		Person person = new Person("a1001", 11111111, 123456789, "vip", "个人业务");
		int i = persondao.save(person);
		if (i > 0) {
			System.out.println("dao的数据保存成功");
		} else {
			System.out.println("dao的数据保存失败");
		}
	}

	private static void searchByQno() {
		PersonDao persondao = new PersonDaoImpl();
		Person person = persondao.searchByQno("a1001");
		System.out.println(person);
	}

	private static void updatePerson() {
		PersonDao persondao = new PersonDaoImpl();
		Person person = new Person("a1001", 22222222, 987654321, "normal", "特殊业务");
		persondao.update(person);
	}

	private static void deletePerson() {
		PersonDao persondao = new PersonDaoImpl();
		persondao.delete("p1001");

	}

	private static void deleteAll() {
		PersonDao persondao = new PersonDaoImpl();
		List<Person> list = persondao.serachAll("");
		for (int i = 0; i < list.size(); i++) {
			persondao.delete(list.get(i).getqNo());
		}
	}

}
