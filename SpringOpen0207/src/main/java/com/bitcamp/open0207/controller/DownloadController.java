package com.bitcamp.open0207.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.open0207.model.Member;
import com.bitcamp.open0207.service.LoginService;

@Controller
public class DownloadController implements ApplicationContextAware {

	private WebApplicationContext context;
	
	@Inject
	private LoginService logService;
	
	@RequestMapping("download/memberXLS")
	public ModelAndView getRanksXls() {
		List<Member> memberXLS = new ArrayList<Member>();
		memberXLS = logService.selectList();
		return new ModelAndView("memberXLS","memberXLS",memberXLS);
	}
	@RequestMapping("download/memberPDF")
	public ModelAndView getRanksPdf() {
		List<Member> memberPDF = new ArrayList<Member>();
		memberPDF = logService.selectList();
		return new ModelAndView("memberPDF","memberPDF",memberPDF);
	}
	
	
	@RequestMapping("/download/file")
	public ModelAndView download() {
		File file = getFile();
		return new ModelAndView("download","downloadFile",file);
	}
	private File getFile() {
		String path = context.getServletContext().getRealPath("/WEB-INF/note.txt");
		return new File(path);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = (WebApplicationContext) applicationContext;
		
	}
	
}
