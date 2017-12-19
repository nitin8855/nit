package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO dao;
	

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}


	public String RegisterEmployee(int eno, String ename, String job, int sal, String addrs) {
		// TODO Auto-generated method stub
		int count =0;
		//use dao
		count=dao.insert(eno, ename, job, sal, addrs);
		if(count==0)
			return eno+"employee is not register";
		else
			return eno+"employee is registerd";
		
	}


	@Override
	public int findEmployeesCount() {
		// TODO Auto-generated method stub
		int count=0;
		//use dao
		count=dao.getEmployeesCount();
		return count;
	}


	@Override
	public Map<String, Object> listEmployeeByNo(int eno) {
		// TODO Auto-generated method stub
		Map<String,Object>map=null;
		//use dao
		map=dao.getEmployeeDetailsByNo(eno);
		return map;
	}


	@Override
	public List<Map<String, Object>> listEmployeesByDesg(String job) {
		// TODO Auto-generated method stub
		List<Map<String,Object>>list=null;
		//use dao
		list=dao.getEmployeeDetailsByDesg(job);
		return list;
	}


	@Override
	public int findEmpSalary(int eno) {
		// TODO Auto-generated method stub
		int salary=0;
		//use dao
		salary=dao.getEmployeeSalaryByNo(eno);
		return salary;
	}


	@Override
	public String hikeEmpSalary(int eno, int percentage) {
		// TODO Auto-generated method stub
		int salary=0;
		float newSalary=0;
		int count=0;
		//get current salary
		salary=findEmpSalary(eno);
		//hike salary
		newSalary=salary+(salary*percentage/100.0f);
		//use dao
		count=dao.updateEmployeeSalary(eno, newSalary);
		if(count==0)
		return eno+" emp salary hicked with"+newSalary+" but not updated";
	else 
		return eno+" emp salary hiked..new salary:"+newSalary+" and updated in DB ";

		
	}


	@Override
	public String fireEmployee(int eno) {
		// TODO Auto-generated method stub
		int count=0;
		//use dao
		count=dao.deleteEmpByNo(eno);
		if(count==0) 
			return eno+" Emp is not deleted";
			   else
				return eno+" emp is deleted"; 
	
	}

}
