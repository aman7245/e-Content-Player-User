package com.project.user.service;

import java.util.List;

import com.project.user.entity.Video;

public interface VideoService {

	public List<Video> findVideosByTopicId(Long topicId);

	public String getSourceLink(Long videoId);

}
