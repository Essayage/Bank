package com.bank.controller;

import com.bank.entity.Person;
import com.bank.entity.Queue;
import com.bank.util.ServiceDispatch;
import com.bank.util.ServiceDispatchImpl;

public class DispOperator {
	static ServiceDispatchImpl dispService = new ServiceDispatchImpl();// queue集合,调用的是其默认的构造方法，不会调用修改后的构造方法

	public  void deleteQueue(String businessType) {// 将某业务队列的第一个用户从其队列中删除
		dispService.dePerson(businessType);
	}

	public static void generateQueue(String businessType1, String businessType2, String businessType3) {
		dispService.addQueue(new Queue(), "1");
		dispService.addQueue(new Queue(), "2");
		dispService.addQueue(new Queue(), "3");
	}

	public static void addPerson(Person person) {
		dispService.addPerson(person);// 将用户加入业务类型1或2或3的队列
	}

	public static ServiceDispatchImpl getDispatch() {// 将生成的queue传递给叫号窗口
		return (ServiceDispatchImpl) dispService;
	}

	public static void transfomQue(Person per, String businessType) {// 交换窗口,将排队号转移至指定业务类型的业务队列中
		dispService.transferPerson(per, businessType);
	}

	public static Person deQueue(String businessType) {
		return dispService.dePerson(businessType);
	}

	public static Person deQueueByQno(String qNo,String businessType) {
		return dispService.dePersonByqNo(qNo, businessType);
	}

	public static int getQueLength(String businessType) {
		return dispService.getQueueLength(businessType);
	}

	public static void main(String[] args) {
		DispOperator disOpe = new DispOperator();
		disOpe.generateQueue("1", "2", "3");
		Person person = new Person("k45645", 14,1, "vip", "1");
		disOpe.addPerson(person);
		Person person1=disOpe.deQueue("1");
		System.out.println(person1);
	}
}
