package com.hk.mechuri.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.mechuri.daos.IMembersDao;
import com.hk.mechuri.daos.MembersDao;
import com.hk.mechuri.dtos.membersDto;
import com.hk.mechuri.mail.MailHandler;
import com.hk.mechuri.mail.TempKey;

@Service
public class MembersService implements IMembersService {
	
	@Autowired
	    private JavaMailSender mailSender;
	    
	
	@Autowired
	private IMembersDao MembersDao;
	
	
	@Override
	public boolean signUpBoard(membersDto dto) {
		return MembersDao.signUpBoard(dto); 
	}

	@Override
	public boolean compSignUpBoard(membersDto dto) {
		return MembersDao.compSignUpBoard(dto); 
	}

	@Override
	public boolean loginCheck(membersDto dto, HttpSession session) {
		boolean result=MembersDao.loginCheck(dto);
		if(result) { // 세션 변수 저장, 세션 관리 기능->controller에서 할 것을 service에 넘겨서 한거...
			membersDto dto2 = viewMember(dto.getMem_id());
			session.setAttribute("mem_id", dto2.getMem_id());
			session.setAttribute("mem_name", dto2.getMem_name());
			session.setAttribute("mem_no", dto2.getMem_no());
			session.setAttribute("mem_status", dto2.getMem_status());
			session.setAttribute("mem_brand", dto2.getMem_brand());
			session.setAttribute("mem_nick", dto2.getMem_nick());
			System.out.println(dto2.getMem_id());
		}
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
		
	}

	@Override
	public membersDto viewMember(String mem_id) {
		return MembersDao.viewMember(mem_id);
	}

	@Override
	public membersDto NaverLogCheck(String mem_email) {
		return MembersDao.NaverLogCheck(mem_email);
	}

	@Override
	public boolean NaverSignUp(String mem_email, String mem_name, String mem_id) {
		return MembersDao.NaverSignUp(mem_email,mem_name,mem_id);
	}

	

	/*@Override
	public Map<String, Object> selectUserInfo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int loginCheck(HashMap<String, String> hstParam) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
	
	/*@Override
	public Map<String, Object> selectUserInfo(Map<String, Object> map) throws Exception {
		return membersDao.selectUserInfo(map);
    }*/
	

/*//	<!-- 로그인 -->
	@Override
	public membersDto memLoginBoard(membersDto dto) {
		System.out.println("memLoginBoard Service");
		return membersDao.memLoginBoard(dto);
	}
	

	public static boolean loginChk(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}*/


}
