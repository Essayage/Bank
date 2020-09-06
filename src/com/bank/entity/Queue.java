package com.bank.entity;

import java.util.LinkedList;

public class Queue {
	
	private LinkedList<Person> list;
	private int length;		//队列长度
	private String queueType;	//队列类型，与排队用户类型一样
	
	public Queue(){
		list = new LinkedList<Person>();
		length = 0;
	}
	
	public Person get(int index){
		
		return list.get(index);
	}
	
	public boolean isEmpty(){
		return length == 0;
	}
	
	public void enQueue(Person per){	//入队
		list.add(per);
		this.length ++;
	}
	
	public Person deQueue(){	//出队
		if (length == 0)
			return null;
		Person per;
		per = list.getFirst();
		list.removeFirst();
		this.length --;
		return per;
	}
	
	public Person getPerson(int index){	//获取队列中指定的位置
		Person per = list.get(index);
		list.remove(index);
		this.length--;
		return per;
	}

	public LinkedList<Person> getQue() {
		return list;
	}
	
	public void swap(int index1, int index2){
		Person per;
		per = list.get(index2);
		list.set(index2, list.get(index1));
		list.set(index1, per);
	}
	
	public void setQue(LinkedList<Person> que) {
		this.list = que;
	}

	public void remove(int index){
		list.remove(index);
		length--;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getQueueType() {
		return queueType;
	}

	public void setQueueType(String queueType) {
		this.queueType = queueType;
	}
}
