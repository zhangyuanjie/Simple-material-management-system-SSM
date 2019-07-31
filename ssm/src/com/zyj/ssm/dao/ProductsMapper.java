package com.zyj.ssm.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.zyj.ssm.pojo.Products;

public interface ProductsMapper {
	List<Products> selectAll(RowBounds rowBounds);
	int selectCount();
	List<Products> selectByName(String keyword);
	List<Products> selectByKeyword(Products products);
	Products selectById(int id);
	void updateInCount(Products products);
	void updateOutCount(Products products);
	void insertProduct(Products products);
	void updateProduct(Products products);
}
