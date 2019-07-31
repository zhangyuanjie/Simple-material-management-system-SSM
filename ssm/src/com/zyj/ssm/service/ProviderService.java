package com.zyj.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyj.ssm.dao.ProviderMapper;
import com.zyj.ssm.pojo.Provider;

@Service
public class ProviderService {
	
	@Autowired
	private ProviderMapper pm;
	
	public List<Provider> selectAll() {
		return pm.selectAll();
	}
	
	public void insertProvider(Provider provider){
		pm.insertProvider(provider);
	}
}
