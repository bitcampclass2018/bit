package com.bitcamp.open0207.service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSendService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void mailSender(String email, String ckcode) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			message.setSubject("가입인증 메일입니다.", "utf-8");
			message.addRecipient(RecipientType.TO, new InternetAddress(email));
			
			String htmlMsg = "<h1>가입인증메일입니다.</h1><a href=\"http://localhost/open0207/Auth/code/"+email+"/"+ckcode+"\">링크를 클릭하세요.</a>";
			message.setText(htmlMsg,"utf-8","html");
			
			javaMailSender.send(message);
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
