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
	
	//查询总记录数
	public int selectCount() {
		return pm.selectCount();
	}
	
	//根据输入的名字进行查询
	public List<Products> selectByName(String keyword){
		return pm.selectByName(keyword);
	}
	
	// 根据输入的关键字进行查询
	public List<Products> selectByKeyword(Products products) {
		return pm.selectByKeyword(products);
	}
	
	// 根据输入的id进行查询
	public Products selectById(int id) {
		return pm.selectById(id);
	}
	
	//入库后更新数量
	public void updateInCount(Products products) {
		pm.updateInCount(products);
	}
	
	// 出库后更新数量
	public void updateOutCount(Products products) {
		pm.updateOutCount(products);
	}
	
	//新产品入库
	public void insertProduct(Products products) {
		pm.insertProduct(products);
	}
	
	// 修改产品
	public void updateProduct(Products products) {
		pm.updateProduct(products);
	}
}
