package com.hk.mechuri.service;

import java.util.Map;

import com.hk.mechuri.dtos.membersDto;

public interface IMembersService {
	public boolean signUpBoard(membersDto dto);
	
	public boolean compSignUpBoard(membersDto dto);

	public void regist(membersDto dto);

	public membersDto userAuth(membersDto dto);
	
/*	public membersDto memLoginBoard(membersDto dto);
	
	public boolean loginChk(Map<String, String> map);

	boolean loginChk(String mem_id); */
}
