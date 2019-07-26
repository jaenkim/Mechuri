package com.hk.mechuri.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
import com.hk.mechuri.mail.MailSend;
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
			session.setAttribute("mem_pw", dto2.getMem_pw());
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
	
	@Override
	   public membersDto existNaverId(membersDto mDto) {
	      return MembersDao.existNaverId(mDto);
	      
	   }
		//네이버 로그인 시 기존 네이버 가입자의 이름과 별명을 가져오는 메서드
	@Override
	public membersDto getNameForNaverMember(String naverEmail) {
		return MembersDao.getNameForNaverMember(naverEmail);
	}
	
	@Override
	public membersDto idcheck(String mem_id) {
		return MembersDao.idcheck(mem_id);
	}


	@Override
	public boolean delflagCheck(membersDto dto) {
		return MembersDao.delflagCheck(dto);
	}

	@Override
	public String memIdSearch(Map<String, String> map) {
		return MembersDao.memIdSearch(map);
	}
	
//	비밀번호 찾기 
	@Override
	public membersDto pwSearch(membersDto dto) {
		return MembersDao.pwSearch(dto);
	}

//	비밀번호 변경 이메일
	@Override
	public boolean pwFind(membersDto dto) {
		
		 StringBuffer temp =new StringBuffer();
         Random rnd = new Random();
         for(int i=0;i<10;i++)
         {
             int rIndex = rnd.nextInt(3);
             switch (rIndex) {
             case 0:
                 // a-z
                 temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                 break;
             case 1:
                 // A-Z
                 temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                 break;
             case 2:
                 // 0-9
                 temp.append((rnd.nextInt(10)));
                 break;
             }
         }
         String AuthenticationKey = temp.toString();
       
		{
			try 
			{
				String mem_id = dto.getMem_id();
				String title = "비밀번호 변경 이메일 입니다.";
				String content = 
						"<html><b>임시 비밀번호는"+ AuthenticationKey +"입니다.</b>";
				
				MailSend ms = new MailSend();
				ms.mailSend(mem_id, title, content);
				
				dto.setMem_pw(AuthenticationKey);
				MembersDao.updatePw(dto);
			
				return true;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return false;
				}
			}	
		}
	}