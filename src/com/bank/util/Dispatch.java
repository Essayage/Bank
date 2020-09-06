package com.bank.util;

import com.bank.entity.Queue;

public interface Dispatch {

	public void addQueue(Queue que, String queueType); // 添加队列

	public int deleteQueue(String queueType);

	public Queue getQueue(String queueType);

	public void handleQueue(String queueType); // 处理对应业务队列
}
