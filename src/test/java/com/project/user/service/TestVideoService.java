package com.project.user.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.project.user.EContentPlayerUserApplicationTests;
import com.project.user.entity.Topic;
import com.project.user.entity.Video;
import com.project.user.repository.VideoRepository;

@Transactional
public class TestVideoService extends EContentPlayerUserApplicationTests{
	
	private static final String TOPIC_NAME = "Topic Test";
	private static final String VIDEO_NAME = "Video Test2";
	private static final long TOPIC_ID = 1L;
	private static final long VIDEO_ID = 1L;
	private static final String FILE_PATH = "A:/temp/download11.jpg";
	
	private VideoServiceImpl videoserv;
	private VideoRepository videoRepo;
	
	@Before
	public void setup(){
		videoRepo = Mockito.mock(VideoRepository.class);
		videoserv = new VideoServiceImpl(videoRepo);
	}
	
	@Test
	public void testFindVideoByTopicID(){
		
		Topic topic = new Topic();
		topic.setTopicId(TOPIC_ID);
		topic.setTopicName(TOPIC_NAME);
		
		Video video = new Video();
		video.setVideoName(VIDEO_NAME);
		video.setVideoPath(FILE_PATH);
		video.setTopic(topic);
		List<Video> list = new ArrayList<>();
		list.add(video);
		
		when(videoRepo.findByTopicTopicId(TOPIC_ID)).thenReturn(list);
		
		List<Video> videos = videoserv.findVideosByTopicId(TOPIC_ID); 
		Assert.assertFalse("Expected NULL", videos.isEmpty());
		Assert.assertEquals(list.size(), videos.size());
		
	}
	
	@Test
	public void testFindVideoByTopicIdNotFound(){
		
		Topic topic = new Topic();
		topic.setTopicId(TOPIC_ID);
		topic.setTopicName(TOPIC_NAME);
		
		Video video = new Video();
		video.setVideoName(VIDEO_NAME);
		video.setVideoPath(FILE_PATH);
		video.setTopic(topic);
		List<Video> list = new ArrayList<>();
		list.add(video);
		
		when(videoRepo.findByTopicTopicId(TOPIC_ID)).thenReturn(list);
		
		Long id = Long.MAX_VALUE;
		List<Video> videos = videoserv.findVideosByTopicId(id);
		Assert.assertTrue("Expected NULL", videos.isEmpty());
		
	}
	
	@Test
	public void testGetSourceLink(){
		Topic topic = new Topic();
		topic.setTopicId(TOPIC_ID);
		topic.setTopicName(TOPIC_NAME);
		
		Video video = new Video();
		video.setVideoId(VIDEO_ID);
		video.setVideoName(VIDEO_NAME);
		video.setVideoPath(FILE_PATH);
		video.setTopic(topic);
		
		when(videoRepo.findOne(VIDEO_ID)).thenReturn(video);
		
		String sourceLink = videoserv.getSourceLink(VIDEO_ID);
		String currentFilePath = FILE_PATH;
		currentFilePath = currentFilePath.substring(8);
		currentFilePath = "/videos/"+currentFilePath;
		
		Assert.assertNotNull(sourceLink);
		Assert.assertEquals(currentFilePath, sourceLink);
	}

}
