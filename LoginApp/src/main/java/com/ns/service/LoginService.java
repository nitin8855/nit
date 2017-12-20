package com.ns.service;

import com.ns.dto.UserDTO;

public interface LoginService {
	
	public String authenticate(UserDTO dto);

}
