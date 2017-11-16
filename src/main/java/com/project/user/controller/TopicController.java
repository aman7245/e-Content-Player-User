package com.project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.user.entity.VideoPackage;
import com.project.user.service.TopicService;
import com.project.user.service.VideoPackageService;

@Controller
@RequestMapping("topic")
public class TopicController {
	
	@Autowired TopicService topicServ;
	@Autowired VideoPackageService videoPackServ;
	
	@RequestMapping(value="/topiclist/{id}",method=RequestMethod.GET)
	public String findTopics(@PathVariable Long id, Model model){
		VideoPackage pack = videoPackServ.findPackageById(id);
		String packageName = pack.getPackageName();
		model.addAttribute("packageName",packageName);
		
		model.addAttribute("topiclist", topicServ.findTopicByPackageId(id));
		
		return "topiclist";
	}

}
