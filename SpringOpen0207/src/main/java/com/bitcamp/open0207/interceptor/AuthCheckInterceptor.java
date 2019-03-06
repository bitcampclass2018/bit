package com.bitcamp.open0207.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		//String url = request.getHeader("referer");
		String url = request.getRequestURI();
		
		System.out.println("이전경로 "+url);
		url = url.substring(9, url.length());
		System.out.println("바꾼경로 "+url);
		if(session!=null) {
			Object authObj = session.getAttribute("loginInfo");
			if(authObj!=null) {
				System.out.println("(로그인상태)정상처리");
				return true;
			}
		}
		System.out.println("비로그인상태");
		response.sendRedirect(request.getContextPath()+"/member/login?url="+url);
		return false;
		
	}
}
