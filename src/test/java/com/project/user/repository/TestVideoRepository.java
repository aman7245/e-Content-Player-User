package com.project.user.repository;

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
import com.project.user.entity.Video;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestVideoRepository {
	
	@Autowired
	 private TestEntityManager entityManager;
	 
	 @Autowired
	 private VideoRepository videoRepo;
	 
	 @Test
	 public void testFindVideosByTopicId(){
		 
		 Topic topic = new Topic();
		 topic.setTopicName("topic007");
		 entityManager.persist(topic);
		 
		 Video video = new Video();
		 video.setVideoName("test video");
		 video.setTopic(topic);
		 entityManager.persist(video);
		 
		 List<Video> videos = videoRepo.findByTopicTopicId(topic.getTopicId());
		 
		 Assert.assertNotNull(videos);
		 Assert.assertEquals(1, videos.size());
		 
	 }

}
