package com.hk.mechuri.service;

import com.hk.mechuri.dtos.membersDto;

public interface IMembersService {
	public boolean signUpBoard(membersDto dto);
	
	public boolean compSignUpBoard(membersDto dto);
	
	membersDto memLoginBoard(String mem_id, String mem_pw);
}
