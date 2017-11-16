package com.project.user.controller;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.user.entity.Login;
import com.project.user.service.LoginService;

@Controller
public class LoginController {

@Autowired LoginService loginserv;
	
	@GetMapping("/")
	public String home(Model model){
		model.addAttribute("login", new Login());
		return "login";
	}
	
	@PostMapping("/login")
	public String allowLogin(@Valid @ModelAttribute Login login, BindingResult result,Model model){
		Exception e;
		try {
				loginserv.checkLogin(login);
			}catch (EntityNotFoundException enf){
				enf.printStackTrace();
				e=enf;
				model.addAttribute("error", e.getMessage());
				return "login";
			} catch (NullPointerException ne){
				ne.printStackTrace();
				e=ne;
				model.addAttribute("error", e.getMessage());
				return "login";
		} 
		return "redirect:/listOfPackage";
	}
}
