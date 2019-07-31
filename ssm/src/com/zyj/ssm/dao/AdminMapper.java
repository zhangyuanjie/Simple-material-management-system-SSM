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
	public void updateFirstErrorLog(String name) ;//��һ�������������
	public void updateState(String name) ;//�����������������࣬����״̬Ϊ����״̬
	public void updateErrorCount(String name) ;//������룬count��һ
	public void initLog(String name) ;//��¼�ɹ��󣬳�ʼ��count��time
	public void updateErrorState(String name) ;//����һ���ʱ�䣬�Զ��ⶳ
}
