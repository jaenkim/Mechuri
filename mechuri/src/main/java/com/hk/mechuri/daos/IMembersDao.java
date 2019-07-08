package com.hk.mechuri.daos;

import com.hk.mechuri.dtos.membersDto;

public interface IMembersDao {
	
	public boolean signUpBoard(membersDto dto);
	
	public boolean compSignUpBoard(membersDto dto);

	membersDto memLoginBoard(String mem_id, String mem_pw);
}
