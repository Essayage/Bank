package com.bank.service;

import java.util.List;

import com.bank.dao.PersonDao;
import com.bank.dao.PersonDaoImpl;
import com.bank.entity.Person;

public class PersonServiceImpl implements PersonService {
	private PersonDao persondao;

	public PersonServiceImpl() {
		this.persondao = new PersonDaoImpl();
	}

	@Override
	public int savePerson(Person person) {
		if (person != null) {
			return this.persondao.save(person);
		}
		return -1;
	}

	@Override
	public int deletePerson(String Qno) {
		Person person = this.getPerson(Qno);
		if (person != null) {
			return this.persondao.delete(Qno);
		}
		return -1;
	}

	@Override
	public Person getPerson(String Qno) {
		return this.persondao.searchByQno(Qno);
	}

	@Override
	public int updatePerson(Person person) {
		Person person1 = this.persondao.searchByQno(person.getqNo());
		if (person1 != null) {
			return this.persondao.update(person);
		}
		return -1;
	}

	@Override
	public List<Person> searchAll(String keyword) {
		if (keyword == null || "".equals(keyword.trim())) {
			keyword = "";
		}
		return this.persondao.serachAll(keyword);
	}

}
