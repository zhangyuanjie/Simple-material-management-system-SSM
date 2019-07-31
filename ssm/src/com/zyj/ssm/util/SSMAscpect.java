package com.zyj.ssm.util;

public class SSMAscpect {
	public void before() {
		System.out.println("权限检查..");
	}
	public void after() {
		System.out.println("记录日志..");
	}
}
