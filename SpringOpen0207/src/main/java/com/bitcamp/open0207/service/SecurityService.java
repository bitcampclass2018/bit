package com.bitcamp.open0207.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.open0207.security.Aes256;

@Service
public class SecurityService {
	
	@Autowired
	private Aes256 aes256;
	
	public String makeCode(String id) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		String encId = aes256.encrypt(id);
		return encId;
	}
	public String makeDecode(String ckcode) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		String deId = aes256.decrypt(ckcode);
		return deId;
	}
}
