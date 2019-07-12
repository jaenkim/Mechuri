package com.hk.mechuri.service;

import java.util.Random;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hk.mechuri.daos.IMembersDao;
import com.hk.mechuri.dtos.membersDto;

@Service
public class UserMailSendService {
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private IMembersDao MembersDao;
	
	// 이메일 난수 만드는 메서드
	private String init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;

		do {
			num = ran.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char) num);
			} else {
				continue;
			}

		} while (sb.length() < size);
		if (lowerCheck) {
			return sb.toString().toLowerCase();
		}
		return sb.toString();
	}

	// 난수를 이용한 키 생성
	private boolean lowerCheck;
	private int size;

	public String getKey(boolean lowerCheck, int size) {
		this.lowerCheck = lowerCheck;
		this.size = size;
		return init();
	}

	// 회원가입 발송 이메일(인증키 발송)
	public boolean mailSendWithUserKey(String mem_email, String mem_id, HttpServletRequest request) {
		
		String member_key = getKey(false, 20);
		System.out.println("memberkey:"+member_key);
		boolean isS= MembersDao.GetKey(mem_id, member_key);
		if(isS) {	
		
		MimeMessage mail = mailSender.createMimeMessage();
		String htmlStr = "<h2>안녕하세요 FLIP~운영자 입니다!</h2><br><br>" 
				+ "<h3>" + mem_id + "님</h3>" + "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : " 
				+ "<a href='http://localhost:8888" + request.getContextPath() + "/key_alter.do?mem_id="+ mem_id +"&member_key="+member_key+"'>인증하기</a></p>"
				+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";
		try {
			mail.setSubject("[본인인증] FLIP 인증메일입니다", "utf-8");
			mail.setText(htmlStr, "utf-8", "html");
			mail.setFrom(new InternetAddress("alfk9393@gmail.com"));
			mail.addRecipient(RecipientType.TO, new InternetAddress(mem_email));
			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return true;
		
		}else {
			return false;
		}
		
	}

	public boolean alter_userKeyService(String mem_id, String mem_key) {
		return  MembersDao.alter_userkey(mem_id, mem_key);	
		
		
	}
/*
	public boolean mailSendWithPassword(String mem_id, String mem_email, HttpServletRequest request) {
		String password_key = getKey(false, 6);
		boolean isS = memberDao.alter_userPassword(mem_id,mem_email,password_key);
		if(isS) {
			MemberDto dto = memberDao.getInfo(mem_id,mem_email);
			String member_name = dto.getMember_name();
			String member_password = dto.getMember_password();

			MimeMessage mail = mailSender.createMimeMessage();
			String htmlStr = "<h2>안녕하세요 '"+ member_name +"' 님</h2><br><br>" 
					+ "<p>비밀번호 찾기를 신청해주셔서 임시 비밀번호를 발급해드렸습니다.</p>"
					+ "<p>임시로 발급 드린 비밀번호는 <h2 style='color : blue'>'" + member_password +"'</h2>이며 로그인 후 마이페이지에서 비밀번호를 변경해주시면 됩니다.</p><br>"
					+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)<br>"
					+ "<a href='http://localhost:8888" + request.getContextPath() +"/loginform.do"+"'>로그인 페이지로 이동하기</a>";
			try {
				mail.setSubject("[MS :p] 임시 비밀번호가 발급되었습니다", "utf-8");
				mail.setText(htmlStr, "utf-8", "html");
				mail.addRecipient(RecipientType.TO, new InternetAddress(mem_email));
				mail.setFrom(new InternetAddress("ilnam4032@gmail.com"));
				mailSender.send(mail);
			} catch (MessagingException e) { 
				e.printStackTrace();
			}
			return true;
		}else {
			return false;
		}*/



		
	}

