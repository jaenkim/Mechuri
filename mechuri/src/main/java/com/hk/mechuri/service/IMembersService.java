package com.hk.mechuri.service;

import java.util.Map;

import com.hk.mechuri.dtos.membersDto;

public interface IMembersService {
	public boolean signUpBoard(membersDto dto);
	
	public boolean compSignUpBoard(membersDto dto);
	
	Map<String, Object> selectUserInfo(Map<String, Object> map) throws Exception;
	
}
