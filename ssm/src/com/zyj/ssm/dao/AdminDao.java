package com.zyj.ssm.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.zyj.ssm.pojo.Admin;

//@Repository("dao")
public class AdminDao extends SqlSessionDaoSupport{
	//@Resource
	private Admin admin;
	
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void insert(Admin admin) {
		this.getSqlSession().insert("com.zyj.ssm.dao.AdminMapper.insertAdmin",admin);
		
		//System.out.println("dao insert: "+admin);
	}
}
