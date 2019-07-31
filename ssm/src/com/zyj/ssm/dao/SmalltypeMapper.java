package com.zyj.ssm.dao;

import java.util.List;

import com.zyj.ssm.pojo.Smalltype;

public interface SmalltypeMapper {
	List<Smalltype> selectAllSmalltype();
	List<Smalltype> selectByBid(int bid);
	void insertSmalltype(Smalltype smalltype);
}
