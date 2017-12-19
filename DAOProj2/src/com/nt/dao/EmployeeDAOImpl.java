package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String REGISTER_EMP="INSERT INTO EMP(ENO,ENAME,JOB,SAL,ADDRS) VALUES(?,?,?,?,?)";
	private static final String GET_EMP_COUNT="SELECT COUNT(*) FROM EMP";
	private static final String GET_EMP_DETAILS_BY_NO="SELECT ENO,ENAME,JOB,SAL,ADDRS FROM EMP WHERE ENO=?";
	private static final String GET_EMP_DETAILS_BY_DESG="SELECT ENO,ENAME,JOB,SAL,ADDRS fROM EMP WHERE JOB=?";
	private static final String GET_EMP_SALARY_BY_NO="SELECT SAL FROM EMP  WHERE ENO=?";
	private static final String UPDATE_EMP_SALARY_BY_NO="UPDATE EMP SET SAL=? where ENO=?";
	private static final String DELETE_EMP_BY_NO="DELETE EMP WHERE ENO=?";
	
	private JdbcTemplate jt;
	

	public JdbcTemplate getJt() {
		return jt;
	}


	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}


	public int insert(int eno,String ename,String job,int sal,String addrs) {
		// TODO Auto-generated method stub
		int count=0;
		count=jt.update(REGISTER_EMP,eno,ename,job,sal,addrs);
		return count;
	}


	@Override
	public int getEmployeesCount() {
		// TODO Auto-generated method stub
		int count=0;
		count=jt.queryForObject(GET_EMP_COUNT, Integer.class);
		return count;
	}


	@Override
	public Map<String, Object> getEmployeeDetailsByNo(int eno) {
		// TODO Auto-generated method stub
		Map<String,Object>map=null;
		map=jt.queryForMap(GET_EMP_DETAILS_BY_NO,eno);
		return map;
	}


	@Override
	public List<Map<String, Object>> getEmployeeDetailsByDesg(String job) {
		// TODO Auto-generated method stub
		List<Map<String,Object>>list=null;
		//execute query
		list=jt.queryForList(GET_EMP_DETAILS_BY_DESG,job);
		return list;
	}


	@Override
	public int updateEmployeeSalary(int eno, float newSalary) {
		// TODO Auto-generated method stub
		int salary=0;
		//execute query
		salary=jt.update(UPDATE_EMP_SALARY_BY_NO, newSalary,eno);
		return 0;
	}


	@Override
	public int getEmployeeSalaryByNo(int eno) {
		// TODO Auto-generated method stub
		int salary=0;
		salary=jt.queryForObject(GET_EMP_SALARY_BY_NO, Integer.class,eno);
		return salary;
	}


	@Override
	public int deleteEmpByNo(int eno) {
		// TODO Auto-generated method stub
		int count=0;
		count=jt.update(DELETE_EMP_BY_NO,eno);
		return count;
	}

}
