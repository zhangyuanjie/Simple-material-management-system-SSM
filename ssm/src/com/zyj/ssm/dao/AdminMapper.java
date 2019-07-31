package com.zyj.ssm.dao;

import java.util.List;

import com.zyj.ssm.pojo.Admin;

public interface AdminMapper {
	public int insertAdmin(Admin admin ) ;
	public Admin selectOne(Admin admin );
	public List<Admin> findAllAdmin();
	public int updateAdmin(Admin admin ) ;
	public Admin selectById(int id );
	public Admin selectByName(String name);
	public void deleteAdmin(int id) ;
	public void updateFirstErrorLog(String name) ;//第一次密码输入错误
	public void updateState(String name) ;//输入密码错误次数过多，更新状态为冻结状态
	public void updateErrorCount(String name) ;//输错密码，count加一
	public void initLog(String name) ;//登录成功后，初始化count，time
	public void updateErrorState(String name) ;//超过一天的时间，自动解冻
}
