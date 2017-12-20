package com.ns.service;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ns.bo.UserBO;
import com.ns.dao.UserDAO;
import com.ns.dto.UserDTO;

@Named("LoginService")
public class LoginServiceImpl implements LoginService {

	@Resource
	private UserDAO dao;
	
	

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}



	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, transactionManager = "dsTxMgr")
	public String authenticate(UserDTO dto) {
		// TODO Auto-generated method stub
		UserBO bo = null;
		int count = 0;
		// convert dto to bo
		bo = new UserBO();
		/*
		 * dto.setUser(bo.getUser()); dto.setPassword(bo.getPassword());
		 */
		BeanUtils.copyProperties(dto, bo);
		// use dao
		count = dao.login(bo);
		// process the result
		if (count == 0)
			return "Invalid Credentials";
		else
			return "valid credentails";

	}

}
