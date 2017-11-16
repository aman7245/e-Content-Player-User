package com.project.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.user.entity.Video;
import com.project.user.repository.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService{

	private VideoRepository videoRepo;
	
	@Autowired
	public VideoServiceImpl(VideoRepository videoRepo) {
		this.videoRepo = videoRepo;
	}

	@Override
	public List<Video> findVideosByTopicId(Long topicId) {
		List<Video> videos = videoRepo.findByTopicTopicId(topicId);
		return videos;
	}

	@Override
	public String getSourceLink(Long videoId) {
		Video video = videoRepo.findOne(videoId);
		String sourceLink = video.getVideoPath();
		sourceLink = sourceLink.substring(8);
		sourceLink = "/videos/"+sourceLink;
		return sourceLink;
	}

}
