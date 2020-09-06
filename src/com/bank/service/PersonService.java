package com.bank.service;

import java.util.List;

import com.bank.entity.Person;

public interface PersonService {
	// 新增存储排队号信息
	int savePerson(Person person);

	// 根据qno删除排队号
	int deletePerson(String Qno);

	// 查询一个排队号信息
	Person getPerson(String Qno);

	// 根据qno更新排队号的信息
	int updatePerson(Person person);

	// 根据传入关键字模糊查询排队号
	List<Person> searchAll(String keyword);

}
