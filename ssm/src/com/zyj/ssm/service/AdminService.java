package com.zyj.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyj.ssm.dao.AdminMapper;
import com.zyj.ssm.pojo.Admin;

@Service
//@Component("as")
//@Transactional
public class AdminService {

	
	@Autowired
	private AdminMapper am;
	public int insert(Admin admin){
		return am.insertAdmin(admin);
	}
	
	public List<Admin> findAllAdmin() {
		return am.findAllAdmin();
	}
	
	public Admin selectOne(Admin admin) {
		return am.selectOne(admin);
	}
	
	public int updateAdmin(Admin admin){
		return am.updateAdmin(admin);
	}
	
	public Admin selectById(int id) {
		return am.selectById(id);
	}
	
	public Admin selectByName(String name) {
		return am.selectByName(name);
	}
	
	public void deleteAdmin(int id){
		am.deleteAdmin(id);
	}
	
	public void updateFirstErrorLog(String name){
		am.updateFirstErrorLog(name);
	}
	
	public void updateState(String name){
		am.updateState(name);
	}
	
	public void updateErrorCount(String name){
		am.updateErrorCount(name);
	}
	
	public void initLog(String name){
		am.initLog(name);
	}
	
	public void updateErrorState(String name){
		am.updateErrorState(name);
	}
}
