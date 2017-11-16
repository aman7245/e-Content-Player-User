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
import com.project.user.entity.VideoPackage;
import com.project.user.repository.TopicRepository;

@Transactional
public class TestTopicService extends EContentPlayerUserApplicationTests{
	
	private static final String PACKAGE_NAME = "package01";
	private static final String PACKAGE_ID = "PACK";
	private static final long TOPIC_ID = 1L;
	private static final String TOPIC_NAME = "Topic";
	private static final long P_ID = 1L;
	
	private TopicServiceImpl topicserv;
	private TopicRepository topicrepo;
	
	@Before
	public void setUp(){
		topicrepo = Mockito.mock(TopicRepository.class);
		topicserv = new TopicServiceImpl(topicrepo);
	}

	@Test
	public void testFindByPackageID(){
		VideoPackage pack = new VideoPackage();
		pack.setId(P_ID);
		pack.setPackageId(PACKAGE_ID);
		pack.setPackageName(PACKAGE_NAME);
		
		Topic topic = new Topic();
		topic.setTopicName(TOPIC_NAME);
		topic.setTopicId(TOPIC_ID);
		topic.setVideoPackage(pack);
		List<Topic> list = new ArrayList<>();
		list.add(topic);
		
		when(topicrepo.findByVideoPackageId(P_ID)).thenReturn(list);
		
		List<Topic> topics = topicserv.findTopicByPackageId(P_ID); 
		Assert.assertNotNull("Expected Not NULL", topics);
		Assert.assertEquals("Expected ID attribute match", 1, topics.size());
		
	}
	
	@Test
	public void testFindByPackageIdNotFound(){
		VideoPackage pack = new VideoPackage();
		pack.setId(P_ID);
		pack.setPackageName(PACKAGE_NAME);
		
		Topic topic = new Topic();
		topic.setTopicName(TOPIC_NAME);
		topic.setTopicId(TOPIC_ID);
		topic.setVideoPackage(pack);
		List<Topic> list = new ArrayList<>();
		list.add(topic);
		
		when(topicrepo.findByVideoPackageId(P_ID)).thenReturn(list);
		
		Long id = Long.MAX_VALUE;
		List<Topic> topics = topicserv.findTopicByPackageId(id);
		Assert.assertTrue("Expected NULL", topics.isEmpty());
		
	}
	
	@Test
	public void testFindByTopicID(){
		Topic topic = new Topic();
		topic.setTopicName(TOPIC_NAME);
		topic.setTopicId(TOPIC_ID);
		
		when(topicrepo.findOne(TOPIC_ID)).thenReturn(topic);
		
		Topic foundtopic = topicserv.findTopicByTopicId(TOPIC_ID); 
		Assert.assertNotNull("Expected Not NULL", foundtopic);
		Assert.assertEquals("Expected ID attribute match", TOPIC_ID, foundtopic.getTopicId());
		
	}
	
	@Test
	public void testFindByTopicIdNotFound(){
		Topic topic = new Topic();
		topic.setTopicName(TOPIC_NAME);
		topic.setTopicId(TOPIC_ID);
		
		when(topicrepo.findOne(TOPIC_ID)).thenReturn(topic);
		
		Long id = Long.MAX_VALUE;
		Topic foundtopic = topicserv.findTopicByTopicId(id); 
		Assert.assertNull("Expected Not NULL", foundtopic);
		
	}
}
