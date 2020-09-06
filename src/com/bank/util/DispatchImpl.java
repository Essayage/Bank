package com.bank.util;

import java.util.ArrayList;

import com.bank.entity.Queue;

public class DispatchImpl implements Dispatch {
	ArrayList<Queue> ques = new ArrayList<Queue>();

	public DispatchImpl() {

	}

	public DispatchImpl(Queue que, String queueType) {
		que.setQueueType(queueType);
		this.ques.add(que);
	}

	public void addQueue(Queue que, String queueType) { // 设置要调度的队列
		que.setQueueType(queueType);
		this.ques.add(que);
	}

	public int deleteQueue(String queueType) {
		if(ques.size() == 0)
			return -1;
		for (int i = 0; i < ques.size();i++)			//根据传进来的参数，删除指定队列
			if(ques.get(i).getQueueType().equals(queueType)){
				ques.remove(i);
				return 1;
			}
		return -1;
	}

	public Queue getQueue(String queueType) {
		for (int i = 0; i < ques.size(); i++) {
			if (ques.get(i).getQueueType().equals(queueType))
				return ques.get(i);
		}
		return null;
	}

	public void handleQueue(String queueType) {
		Queue que = null;
		que = getQueue(queueType); // 根据传进来的参数，来处理指定队列，整理队列的顺序

		for (int i = 0; i < que.getLength(); i++) {
			for (int j = 0; j < que.getLength() - i - 1; j++) {
				if (que.get(j).compareTo(que.get(j + 1)) == -1) {
					que.swap(j, j + 1);
				}
			}
		}
	}
}
