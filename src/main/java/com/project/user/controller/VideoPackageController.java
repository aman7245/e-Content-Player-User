package com.project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.user.service.VideoPackageService;

@Controller
public class VideoPackageController {

	@Autowired VideoPackageService videoPackServ;
	
	@RequestMapping(value="/listOfPackage",method=RequestMethod.GET)
	public String findPackage(Model model){
		
		model.addAttribute("list",videoPackServ.findAllVideoPackages());	
		return "packagelist";
		
	}
}
