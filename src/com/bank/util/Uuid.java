package com.bank.util;

import java.util.UUID;

public class Uuid {
	public static String uuidCard() {
		int machineId = 1; // 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		return machineId + String.format("%011d", hashCodeV);
	}

	public static String uuidPno() {
		int machineId = 2; // 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		return machineId + String.format("%011d", hashCodeV);
	}

	public static int uuidInt() {
		int machineId = 1; // 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}

		String str = machineId + String.format("%011d", hashCodeV);

		return Integer.parseInt(str.substring(0, 6));
	}

	public static void main(String[] args) {
		System.out.println("账号：" + uuidInt());
	}

}
