package com.zyj.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyj.ssm.dao.SmalltypeMapper;
import com.zyj.ssm.pojo.Smalltype;

@Service
public class SmalltypeService {
	
	@Autowired
	private SmalltypeMapper sm;
	public List<Smalltype> selectAllSmalltype(){
		return sm.selectAllSmalltype();
	}
	
	public List<Smalltype> selectByBid(int bid){
		return sm.selectByBid(bid);
	}
	
	public void insertSmalltype(Smalltype smalltype) {
		sm.insertSmalltype(smalltype);
	}
}
