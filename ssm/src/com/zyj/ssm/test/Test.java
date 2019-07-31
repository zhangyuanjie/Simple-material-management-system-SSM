package com.zyj.ssm.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyj.ssm.dao.AdminDao;
import com.zyj.ssm.pojo.Admin;
import com.zyj.ssm.pojo.Products;
import com.zyj.ssm.service.AdminService;
import com.zyj.ssm.service.ProductsService;
import com.zyj.ssm.util.MD5Code;

public class Test {
	public static void main(String[] args) {
//		Admin a = new Admin();
//		a.setName("刘邦");
//		a.setPwd("123");
//		System.out.println(a);
//		a = null;
//		//运行垃圾回收器
//		System.gc();
		
		
		//spring相关配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MD5Code md5 = new MD5Code();
		
		Admin admin = (Admin) context.getBean("admin");
		admin.setName("zy");
		admin.setPwd("666");
		admin.setState(0);
		System.out.println(admin);
		
//		Admin admin2 = (Admin) context.getBean("admin");
//		admin2.setName("韩信");
//		admin2.setPwd("555");
//		System.out.println(admin2);
		
		AdminDao adminDao = (AdminDao)context.getBean("dao");
		
		//adminDao.insert();
		
		AdminService adminService = (AdminService)context.getBean("as");
		ProductsService productsService = (ProductsService)context.getBean("ps");
		adminService.insert(admin);
//		List<Products> products = productsService.selectAll();
//		for(Products p:products){
//			System.out.println(p);
//		}
		
		
	}
}
