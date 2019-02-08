package com.bitcamp.open0207.model;

public class Emp {
	private int idx;
	private String empno;
	private String empname;
	private String deptno;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "Emp [idx=" + idx + ", empno=" + empno + ", empname=" + empname + ", deptno=" + deptno + "]";
	}
	
	
}
