package com.bitcamp.open0207.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitcamp.open0207.dao.EmpDao;
import com.bitcamp.open0207.model.Emp;

@Service
public class EmpService {
	
	@Inject
	private EmpDao dao;
	
	public int insertEmp(Emp emp) {
		return dao.insertEmp(emp);
	}
	public List<Emp> selectEmpList(){
		return dao.selectEmpList();
	}
}
