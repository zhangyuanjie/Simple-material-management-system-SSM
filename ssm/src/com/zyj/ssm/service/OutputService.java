package com.zyj.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyj.ssm.dao.OutputMapper;
import com.zyj.ssm.pojo.Output;
import com.zyj.ssm.pojo.ProInOutput;

@Service
public class OutputService {
	@Autowired
	private OutputMapper om;
	
	public List<Output> selectAllOutput(){
		return om.selectAllOutput();
	}
	
	public void insertOutput(Output output) {
		om.insertOutput(output);
	}
	
	public List<Output> selectOutputByKeyword(ProInOutput proInOutput){
		return om.selectOutputByKeyword(proInOutput);
	}
	
	public List<Output> selectOutByName(){
		return om.selectOutByName();
	}
}
