package com.hk.mechuri.daos;

import java.util.Map;

import com.hk.mechuri.dtos.membersDto;

public interface IMembersDao {
	
	public boolean signUpBoard(membersDto dto);
	
	public boolean compSignUpBoard(membersDto dto);

	/*public membersDto memLoginBoard(membersDto dto);
	
	public int loginChk(String mem_id); */
}
