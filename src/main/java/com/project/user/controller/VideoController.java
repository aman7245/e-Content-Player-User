package com.project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.user.entity.Topic;
import com.project.user.service.TopicService;
import com.project.user.service.VideoService;

@Controller
@RequestMapping("/video")
public class VideoController {

	@Autowired VideoService videoServ;
	@Autowired TopicService topicServ;
	
	 @RequestMapping(value="/videolist/{topicId}",method=RequestMethod.GET)
		public String findVideos(@PathVariable Long topicId, Model model){
			Topic topic = topicServ.findTopicByTopicId(topicId);
			model.addAttribute("topicName", topic.getTopicName());
	    	model.addAttribute("videoList", videoServ.findVideosByTopicId(topicId));
			
			return "videolist";
	    }
	
	 @RequestMapping(value="/playvideo/{videoId}",method=RequestMethod.GET)
		public String playVideo(@PathVariable Long videoId, Model model){
		
		 String sourceLink = videoServ.getSourceLink(videoId);
		 model.addAttribute("sourceLink", sourceLink);
		 
		 return "playvideo";
	 }
}
