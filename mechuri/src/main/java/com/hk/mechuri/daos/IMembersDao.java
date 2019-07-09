package com.hk.mechuri.daos;

import java.util.Map;

import com.hk.mechuri.dtos.membersDto;

public interface IMembersDao {
	
	public boolean signUpBoard(membersDto dto);
	
	public boolean compSignUpBoard(membersDto dto);

	void createAuthKey(String mem_email, String User_authCode) throws Exception;

	void insertUser(membersDto dto) throws Exception;

	public void userAuth(String mem_email) throws Exception;

	membersDto chkAuth(membersDto s) throws Exception;

	void userAuth(membersDto dto) throws Exception;

	membersDto authenticate(String str) throws Exception;

	void createAuthKey(String memberEmail, String memberAuthKey, membersDto dto) throws Exception;

	/*public membersDto memLoginBoard(membersDto dto);
	
	public int loginChk(String mem_id); */
}
