package com.zyj.ssm.dao;

import java.util.List;

import com.zyj.ssm.pojo.Bigtype;

public interface BigtypeMapper {
	public List<Bigtype> selectAll();
	public void insertBigtype(Bigtype bigtype);
}
