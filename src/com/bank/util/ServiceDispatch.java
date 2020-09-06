package com.bank.util;

import com.bank.entity.Person;
import com.bank.entity.Queue;

public interface ServiceDispatch {

	public void addQueue(Queue que,String queueType);	//添加业务队列
	
	public void addPerson(Person per);					//增加用户
	
	public Person dePerson(String businessType);		//获得对应业务队列的队头用户
	
	public int deleteQueue(String queueType);			//删除业务队列
	
	public void transferPerson(Person per,String businessType);	//转移用户，第一个参数是用户，第二个是要转移到的业务
	
	public int getQueueLength(String businessType);
	
	public Person dePersonByqNo(String qNo,String businessType);}
