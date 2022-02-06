package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.data.UserLoginData;
import com.user.service.JwtUserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private JwtUserService jwtUserService;

	@ResponseBody
	@PostMapping("/getToken")
	public String getToken(@RequestBody UserLoginData userLoginData) throws Exception 
	{
		return jwtUserService.getToken(userLoginData.getUserName(), userLoginData.getPassword());
	}
}
