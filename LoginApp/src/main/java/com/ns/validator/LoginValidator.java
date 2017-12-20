package com.ns.validator;

import javax.inject.Named;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ns.command.UserCommand;

@Named("validator")
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(UserCommand.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		// TODO Auto-generated method stub
		UserCommand cmd = null;
		// type Casting
		cmd = (UserCommand) command;
		// write validation logic
		if (cmd.getUser().equals(""))
			errors.rejectValue("usre", "login.user");
		if (cmd.getPwd().equals(""))
			errors.rejectValue("pwd", "login.pwd");
		else {
			if (cmd.getPwd().length() < 4)
				errors.rejectValue("pwd", "login.pwd.size");
		}

	}

}
