package com.project.user.repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.user.entity.Topic;
import com.project.user.entity.VideoPackage;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestTopicRepository {
	
	@Autowired
	 private TestEntityManager entityManager;
	
	@Autowired
	private TopicRepository topicRepo;
	
	@Test
	 public void testFindTopicsByPackagesId()throws Exception{
		 
		 String date="31/03/2017";  
		 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		 VideoPackage videoPackage = new VideoPackage();
		 videoPackage.setPackageId("PACK01A");
		 videoPackage.setPackageName("package 01A");
		 videoPackage.setValidFrom(date1);
		 videoPackage.setValidTill(30);
		 entityManager.persist(videoPackage);
		 
		 Topic topic = new Topic();
		 topic.setTopicName("topic007");
		 topic.setVideoPackage(videoPackage);
		 
		 entityManager.persist(topic);
		 List<Topic> foundTopics = topicRepo.findByVideoPackageId(videoPackage.getId());
		 Assert.assertNotNull(foundTopics);
		 Assert.assertEquals(1, foundTopics.size());
	 }

}
