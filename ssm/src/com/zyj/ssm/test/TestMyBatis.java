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
		//读取MyBatis配置文件以及加载映射文件
		InputStream is = Resources.getResourceAsStream(resource);
		//构造会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		//创建会话对象
		SqlSession session = sessionFactory.openSession();
		//List<Admin> list = session.selectList("com.zyj.ssm.dao.AdminMapper.findAll");
//		for(Admin admin:list){
//			System.err.println(admin);
//		}
		//System.out.println(list);
		
		/*Admin admin = session.selectOne("com.zyj.ssm.dao.AdminMapper.findById",1);
		System.out.println(admin);
		
		//分页有些已知条件时
		int pageSize = 3;//每页显示的记录数（可由用户输入）
		int currentPage = 1;//当前页（用户选择，默认第一页）
		
		//分页查询
		List<Admin> list2 = session.selectList("com.zyj.ssm.dao.AdminMapper.findAll",
						null,new RowBounds((currentPage-1)*pageSize,pageSize));
		System.out.println(list2);
		*/
		//插入数据
//		Admin admin = new Admin();
//		admin.setName("张三");
//		admin.setPwd("123");
//		admin.setState(9);
//		int r = session.insert("com.zyj.ssm.dao.AdminMapper.insertAdmin", admin);
		
		//System.out.println(r);
		//如果是增删改的话，则需要提交事务
		
		//int r = session.insert("com.zyj.ssm.dao.AdminMapper.deleteAdmin", 4);
		
		//修改的流程
		//1、先把内容查出来
		Admin admin = session.selectOne("com.zyj.ssm.dao.AdminMapper.findById",9);
		//2、把可以修改的进行修改
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
