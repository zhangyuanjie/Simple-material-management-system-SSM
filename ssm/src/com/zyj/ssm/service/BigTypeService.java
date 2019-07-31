package com.zyj.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyj.ssm.dao.BigtypeMapper;
import com.zyj.ssm.pojo.Bigtype;

@Service
@Transactional
public class BigTypeService {

	@Autowired
	private BigtypeMapper bm;
	
	public List<Bigtype> selectAll() {
		return bm.selectAll();
	}
	
	public void insertBigtype(Bigtype bigtype) {
		bm.insertBigtype(bigtype);
	}
}
