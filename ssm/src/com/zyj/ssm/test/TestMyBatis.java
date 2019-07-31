package com.zyj.ssm.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zyj.ssm.pojo.Admin;

public class TestMyBatis {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		//��ȡMyBatis�����ļ��Լ�����ӳ���ļ�
		InputStream is = Resources.getResourceAsStream(resource);
		//����Ự����
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		//�����Ự����
		SqlSession session = sessionFactory.openSession();
		//List<Admin> list = session.selectList("com.zyj.ssm.dao.AdminMapper.findAll");
//		for(Admin admin:list){
//			System.err.println(admin);
//		}
		//System.out.println(list);
		
		/*Admin admin = session.selectOne("com.zyj.ssm.dao.AdminMapper.findById",1);
		System.out.println(admin);
		
		//��ҳ��Щ��֪����ʱ
		int pageSize = 3;//ÿҳ��ʾ�ļ�¼���������û����룩
		int currentPage = 1;//��ǰҳ���û�ѡ��Ĭ�ϵ�һҳ��
		
		//��ҳ��ѯ
		List<Admin> list2 = session.selectList("com.zyj.ssm.dao.AdminMapper.findAll",
						null,new RowBounds((currentPage-1)*pageSize,pageSize));
		System.out.println(list2);
		*/
		//��������
//		Admin admin = new Admin();
//		admin.setName("����");
//		admin.setPwd("123");
//		admin.setState(9);
//		int r = session.insert("com.zyj.ssm.dao.AdminMapper.insertAdmin", admin);
		
		//System.out.println(r);
		//�������ɾ�ĵĻ�������Ҫ�ύ����
		
		//int r = session.insert("com.zyj.ssm.dao.AdminMapper.deleteAdmin", 4);
		
		//�޸ĵ�����
		//1���Ȱ����ݲ����
		Admin admin = session.selectOne("com.zyj.ssm.dao.AdminMapper.findById",9);
		//2���ѿ����޸ĵĽ����޸�
		System.out.println(admin);
		admin.setName("liu");
		admin.setPwd("1111");
		admin.setState(0);
		session.update("com.zyj.ssm.dao.AdminMapper.updateAdmin",admin);
		System.out.println(admin);
		
		session.commit();
		//System.out.println(r);
		session.close();
		
	}
}
