package com.zyj.ssm.dao;

import java.util.List;

import com.zyj.ssm.pojo.Provider;

public interface ProviderMapper {

	public List<Provider> selectAll() ;
	public void insertProvider(Provider provider);
}
