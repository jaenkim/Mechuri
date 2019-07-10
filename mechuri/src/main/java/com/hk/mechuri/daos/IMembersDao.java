package com.hk.mechuri.daos;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.hk.mechuri.dtos.membersDto;

public interface IMembersDao {
	
	public boolean signUpBoard(membersDto dto);
	
	public boolean compSignUpBoard(membersDto dto);
	
	public boolean login_Check(membersDto dto);
	
	public membersDto viewMember(String userid);
}
