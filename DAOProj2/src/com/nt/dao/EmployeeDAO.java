package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
	
	public int insert(int eno,String ename,String job,int sal,String addrs);
	public int getEmployeesCount();
	public Map<String,Object>getEmployeeDetailsByNo(int eno);
	public List<Map<String,Object>> getEmployeeDetailsByDesg(String job);
	public int getEmployeeSalaryByNo(int eno);
	public int updateEmployeeSalary(int eno,float newSalary);
	public int deleteEmpByNo(int eno);

}
