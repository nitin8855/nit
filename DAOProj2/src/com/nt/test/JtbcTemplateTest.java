package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.EmployeeService;

public class JtbcTemplateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=null; 
		EmployeeService service=null;
		//create ioc container
		ctx=new FileSystemXmlApplicationContext("src/com/nt/cfg/applicationContext.xml");
		service=ctx.getBean("empService",EmployeeService.class);
		try {
			//System.out.println(service.RegisterEmployee(112, "nit", "oracle", 400, "hyd"));
			//System.out.println("Employees Count:::"+service.findEmployeesCount());
			//System.out.println("emp daitails of 111"+service.listEmployeeByNo(111));
			//System.out.println("java desg Employee Details:::"+service.listEmployeesByDesg("java"));
			//System.out.println("1001 Emp Salary:::"+service.findEmpSalary(111));
			//System.out.println(service.hikeEmpSalary(111,1));
			//System.out.println("1001 Employee Details:::"+service.listEmployeeByNo(111));
			System.out.println(service.fireEmployee(1001));
		
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		((AbstractApplicationContext) ctx).close();

	}

}
