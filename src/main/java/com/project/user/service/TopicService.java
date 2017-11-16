package com.project.user.service;

import java.util.List;

import com.project.user.entity.Topic;

public interface TopicService {

	public List<Topic> findTopicByPackageId(Long id);
	public Topic findTopicByTopicId(Long topicId);

}
