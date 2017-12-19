package com.nt.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
	public String RegisterEmployee(int eno,String ename,String job,int sal,String addrs);
	public int  findEmployeesCount();
	public Map<String,Object>listEmployeeByNo(int eno);
	public List<Map<String,Object>> listEmployeesByDesg(String job);
	public int findEmpSalary(int eno);
	public String hikeEmpSalary(int eno,int percentage);
	public String fireEmployee(int eno);
	


}
