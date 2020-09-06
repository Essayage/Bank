package com.bank.util;

import com.bank.entity.Person;
import com.bank.entity.Queue;

public class ServiceDispatchImpl implements ServiceDispatch {
	
	DispatchImpl disp =new DispatchImpl();
	
	public ServiceDispatchImpl(){
		disp = new DispatchImpl();
	}
	
	@Override
	public void addQueue(Queue que,String queueType){	//增加一条队列，负责某个业务
		disp.addQueue(que, queueType);
	}
	
	@Override
	public void addPerson(Person per){		//将用户加入对应的队列
		disp.getQueue(per.getbusinessType()).enQueue(per);
		disp.handleQueue(per.getbusinessType());
	}
	
	@Override
	public Person dePerson(String businessType){	//获得对应业务队列的队头用户
		
		return disp.getQueue(businessType).deQueue();
	}
	
	@Override
	public Person dePersonByqNo(String qNo,String businessType) {	//指定排队号出队
		Queue que = disp.getQueue(businessType);
		if (que == null) return null;
		for (int i = 0; i < que.getLength(); i++){
			if(que.get(i).getqNo().equals(qNo)){
				return que.getPerson(i);	//指定排队号的人出队
			}
		}
		return null;
	}
	
	@Override
	public int deleteQueue(String queueType){		//删除指定业务队列
		return disp.deleteQueue(queueType);			//成功返回1， 错误返回-1
	}
	
	@Override
	public void transferPerson(Person per,String businessType){	//将用户转移到另一个业务队列
		Queue que = disp.getQueue(per.getbusinessType());
		for (int i = 0; i < que.getLength();i++){
			if(que.get(i).getqNo().equals(per.getqNo())){
				per.setbusinessType(businessType);		//重新设置该用户业务类型
				addPerson(per);
				que.remove(i);			//删除原队列中的用户
				break;
			}
		}	
	}

	@Override
	public int getQueueLength(String businessType) {	//返回指定队列长度，若不存在该队列则返回-1
		Queue que;
		que = disp.getQueue(businessType);
		if (que != null){
			return que.getLength();
		}
		return -1;
	}
	
	public static void main(String[] args){
		ServiceDispatchImpl serdisp = new ServiceDispatchImpl();
		serdisp.addQueue(new Queue(), "现金业务"); 		//增加两条队列，一条负责现金业务，一条负责转账业务
		serdisp.addQueue(new Queue(), "转账业务");
		
		Person[] persons = new Person[12];		//创建12个用户
		persons[0]= new Person();
		persons[0].setqNo("1");
		persons[0].setType("普通用户");
		persons[0].setbusinessType("现金业务");
		persons[1]= new Person();
		persons[1].setqNo("2");
		persons[1].setType("普通用户");
		persons[1].setbusinessType("现金业务");
		persons[2]= new Person();
		persons[2].setqNo("3");
		persons[2].setType("VIP");
		persons[2].setbusinessType("现金业务");
		persons[3]= new Person();
		persons[3].setqNo("4");
		persons[3].setType("VIP");
		persons[3].setbusinessType("现金业务");
		persons[4]= new Person();
		persons[4].setqNo("5");
		persons[4].setType("普通用户");
		persons[4].setbusinessType("现金业务");
		persons[5]= new Person();
		persons[5].setqNo("6");
		persons[5].setType("普通用户");
		persons[5].setbusinessType("现金业务");
		persons[6]= new Person();
		persons[6].setqNo("7");
		persons[6].setType("VIP");
		persons[6].setbusinessType("现金业务");
		persons[7]= new Person();
		persons[7].setqNo("8");
		persons[7].setType("VIP");
		persons[7].setbusinessType("现金业务");
		persons[8]= new Person();
		persons[8].setqNo("9");
		persons[8].setType("普通用户");
		persons[8].setbusinessType("现金业务");
		persons[9]= new Person();
		persons[9].setqNo("10");
		persons[9].setType("普通用户");
		persons[9].setbusinessType("现金业务");
		persons[10]= new Person();
		persons[10].setqNo("11");
		persons[10].setType("VIP");
		persons[10].setbusinessType("现金业务");
		persons[11]= new Person();
		persons[11].setqNo("12");
		persons[11].setType("普通用户");
		persons[11].setbusinessType("现金业务");
		
		
		
		for (int i = 0; i < persons.length; i ++){
			serdisp.addPerson(persons[i]);	//将用户添加进来
		}
		
		//System.out.println(serdisp.dePersonByqNo("7", "现金业务").getqNo());
		
		//System.out.println("现金业务队列长度：" + serdisp.getQueueLength("现金业务"));
		//System.out.println("asdf队列长度：" + serdisp.getQueueLength("adf"));
		//serdisp.transferPerson(persons[2], "现金业务");		//第一个参数是用户，第二个是要转移到的业务
		//serdisp.transferPerson(persons[8], "转账业务");
		
		for (int j = 0; j < 12; j ++){
			System.out.println(serdisp.dePerson("现金业务").getqNo());
		}
	}

}
