package com.bitcamp.open0207.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open0207.model.Board;
import com.bitcamp.open0207.model.Emp;
import com.bitcamp.open0207.service.EmpService;

@Controller
public class EmpController {
	
	@Inject
	private EmpService eService;
	
	@RequestMapping(value="/emp/insert", method=RequestMethod.GET)
	public String getForm() {
		return "emp/empForm";
	}
	@RequestMapping(value="/emp/insert", method=RequestMethod.POST) 
	public String insertBoard(HttpServletRequest request,
			@RequestParam("empno") String empno,
			@RequestParam("empname") String empname,
			@RequestParam("deptno") String deptno
			) {
	
		
		Emp emp = new Emp();
		emp.setEmpno(empno);
		emp.setEmpname(empname);
		emp.setDeptno(deptno);
		
		eService.insertEmp(emp);
	
		
		return "emp/insert";
	}
	
	@RequestMapping("/emp/list")
	public String selectList(Model model) {
		List<Emp> emps = eService.selectEmpList();
		model.addAttribute("emps", emps);
		return "emp/list";
	}
	
}
