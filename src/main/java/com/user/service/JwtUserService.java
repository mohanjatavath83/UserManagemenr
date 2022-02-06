package com.user.service;

import com.user.config.JwtTokenUtil;
import com.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "jwtUserService")
public class JwtUserService implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException
	{
		System.out.println("second method is invoked");
		UserModel userModel = userService.getUserById(userId);
		User user = new User(userModel.getUid(), userModel.getPassword(), new ArrayList<>());

		return user;
	}
	
	public String getToken(String userId, String password) throws Exception {
		try {
			System.out.println("first method is invoked");

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
		} catch (DisabledException ex) {
			ex.printStackTrace();
			throw new Exception("USER_DISABLED");
		} catch (BadCredentialsException ex) {
			ex.printStackTrace();
			throw new Exception("INVALID_CREDENTIALS");
		}
		
		return jwtTokenUtil.generateToken(userId);
		
	}

}
