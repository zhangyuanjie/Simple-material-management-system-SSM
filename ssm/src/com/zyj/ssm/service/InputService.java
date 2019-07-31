package com.zyj.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyj.ssm.dao.InputMapper;
import com.zyj.ssm.pojo.Input;
import com.zyj.ssm.pojo.ProInOutput;

@Service
public class InputService {
	@Autowired InputMapper im;
	
	public int insertInput(Input input){
		return im.insertInput(input);
	}
	
	public List<Input> selectAllInput(){
		return im.selectAllInput();
	}
	
	public List<Input> selectInputByKeyword(ProInOutput proInOutput) {
		return im.selectInputByKeyword(proInOutput);
	}
	
	public List<Input> selectInByName(){
		return im.selectInByName();
	}
}
