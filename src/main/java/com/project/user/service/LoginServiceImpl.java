package com.project.user.service;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.user.entity.Login;
import com.project.user.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired LoginRepository loginrepo;
	
	@Override
	public Login checkLogin(Login login) {
		
		Login check = loginrepo.findOne(1L);

		if(login.getUsername()==null)
		{
			throw new NullPointerException("Feild should not be blank");
		}
		if(login.getPassword().equals(check.getPassword())){
			System.out.println("Login Successful");
		}
		else{
			throw new EntityNotFoundException("Invalid Username and Password");
		}
			
		
		return check;
	}

}
