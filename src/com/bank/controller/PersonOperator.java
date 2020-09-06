package com.bank.controller;

import com.bank.entity.Person;
import com.bank.entity.Queue;
import com.bank.service.PersonService;
import com.bank.service.PersonServiceImpl;
import com.bank.util.ServiceDispatch;
import com.bank.util.ServiceDispatchImpl;

public class PersonOperator {
	private static PersonService personService = new PersonServiceImpl();

	public static int savePerson(String qNo, int cNo, int userId, String type, String businessType) {// 将排队号存入数据库中
		int i = -1;
		Person person = new Person(qNo, cNo, userId, type, businessType);
		i = personService.savePerson(person);
		return i;// 成功，i值为存储成功的个数，大于0，失败则i为-1
	}

	public static int deletePerson(String qNo) {// 将排队号从数据库中删除
		int i = -1;
		i = personService.deletePerson(qNo);
		return i;
	}

	public static void main(String[] args) {
		deletePerson("p1002");
	}
}
