package com.project.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.user.entity.Topic;
import com.project.user.repository.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService{

	private TopicRepository topicRepo;
	
	@Autowired
	public TopicServiceImpl(TopicRepository topicRepo){
		this.topicRepo = topicRepo;
	}
	
	@Override
	public List<Topic> findTopicByPackageId(Long id) {
		
		List<Topic> topics = topicRepo.findByVideoPackageId(id);
		
		return topics;
	}
	@Override
	public Topic findTopicByTopicId(Long topicId) {
		Topic topic = topicRepo.findOne(topicId);
		return topic;
	}

}
