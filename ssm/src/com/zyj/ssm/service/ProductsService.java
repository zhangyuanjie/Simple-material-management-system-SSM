package com.zyj.ssm.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zyj.ssm.dao.ProductsMapper;
import com.zyj.ssm.pojo.Products;

@Component("ps")
@Transactional
public class ProductsService {
	
	@Autowired
	private ProductsMapper pm;
	
	public List<Products> selectAll(RowBounds rowBounds) {
		return pm.selectAll(rowBounds);
	}
	
	//��ѯ�ܼ�¼��
	public int selectCount() {
		return pm.selectCount();
	}
	
	//������������ֽ��в�ѯ
	public List<Products> selectByName(String keyword){
		return pm.selectByName(keyword);
	}
	
	// ��������Ĺؼ��ֽ��в�ѯ
	public List<Products> selectByKeyword(Products products) {
		return pm.selectByKeyword(products);
	}
	
	// ���������id���в�ѯ
	public Products selectById(int id) {
		return pm.selectById(id);
	}
	
	//�����������
	public void updateInCount(Products products) {
		pm.updateInCount(products);
	}
	
	// ������������
	public void updateOutCount(Products products) {
		pm.updateOutCount(products);
	}
	
	//�²�Ʒ���
	public void insertProduct(Products products) {
		pm.insertProduct(products);
	}
	
	// �޸Ĳ�Ʒ
	public void updateProduct(Products products) {
		pm.updateProduct(products);
	}
}
