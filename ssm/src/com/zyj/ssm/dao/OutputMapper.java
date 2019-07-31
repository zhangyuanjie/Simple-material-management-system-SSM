package com.zyj.ssm.dao;

import java.util.List;

import com.zyj.ssm.pojo.Output;
import com.zyj.ssm.pojo.ProInOutput;

public interface OutputMapper {
	public List<Output> selectAllOutput();
	public void insertOutput(Output output);
	public List<Output> selectOutputByKeyword(ProInOutput proInOutput);
	public List<Output> selectOutByName();
}
