package com.ns.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ns.command.UserCommand;
import com.ns.dto.UserDTO;
import com.ns.service.LoginService;

@Controller
public class LoginController {
	@Resource
	private LoginService service;
	
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String showForm(@ModelAttribute("userCmd") UserCommand cmd) {
		
		
		return "login";	
	}
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String ProcessForm(Map<String,Object>map, @ModelAttribute("userCmd") UserCommand cmd) {
		
		UserDTO dto=null;
		String result=null;
		//conver command class object to dto class obj
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		result=service.authenticate(dto);
		//add result to model attribute
		map.put("result", result);
		return "login";
		
	}

}
