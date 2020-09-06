package com.bank.dao;

import java.util.List;

import com.bank.entity.Person;

public interface PersonDao {
	// 增加一个
	int save(Person person);

	// 删除
	int delete(String qno);

	// 修改信息
	int update(Person person);

	// 查询信息
	Person searchByQno(String string);

	// 查询关键字
	List<Person> serachAll(String keyword);
}
