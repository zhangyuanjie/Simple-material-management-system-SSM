package com.zyj.ssm.dao;

import java.util.List;

import com.zyj.ssm.pojo.Input;
import com.zyj.ssm.pojo.ProInOutput;

public interface InputMapper {
	public int insertInput(Input input);
	List<Input> selectAllInput();
	List<Input> selectInputByKeyword(ProInOutput proInOutput);
	List<Input> selectInByName();
}
