package com.ns.dao;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ns.bo.UserBO;
@Named("login")
public class UserDAOImpl implements UserDAO {
	private static final String AUTH_QUERY="SELECT COUNT (*) FROM USERLIST WHERE USERNAME=? AND PWD=?";
	@Resource
	private JdbcTemplate jt;
	

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}


	public int login(UserBO bo) {
		// TODO Auto-generated method stub
		
		int count=0;
		///execute query
		count=jt.queryForObject(AUTH_QUERY, Integer.class);
		return count;
	}

}
