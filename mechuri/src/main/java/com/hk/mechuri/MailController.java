package com.hk.mechuri;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hk.mechuri.mail.MailSend;

@Controller
public class MailController {
	
	// 3. Controller
//	@Autowired
//	private JavaMailSender MailSender;
	
	//이메일 아이디 중복확인
	@RequestMapping(value = "/mail.do", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Integer mail(Model model, String email) 
	{
		MailSend ms = new MailSend();
		
		String title = "회원가입 인증코드 발급안내 입니다.";
		
		Random random = new Random();
		int result = random.nextInt(10000)+1000;
		if(result>10000) {
			result = result - 1000;
		}
		String content = "회원님의 인증 코드는 " + result +" 입니다.";
		ms.mailSend(email, title, content);
		
		return result;
	}
	
	
	
	/*//비밀번호 찾기
		// mailSending 코드
	@RequestMapping(value ="/mailSending.do")
	public String mailSending(HttpServletRequest request) {

		String setfrom = "mydictionarykor@gmail.com";
		String tomail = request.getParameter("email"); // 받는 사람 이메일
		String title = request.getParameter("title"); // 보내는 사람 제목
		String content = request.getParameter("content"); // 보내는 사람 내용

		try {
			MimeMessage message = MailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(content); // 메일 내용

			MailSender.send(message);

		} catch (Exception e) {
			System.out.println(e);
		}

		return "redirect:/registForm.do";
	}*/
}
