package com.project.user.repository;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.user.entity.VideoPackage;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestVideoPackageRepository {
	
	@Autowired
	 private TestEntityManager entityManager;
	@Autowired
	private VideoPackageRepository videoPackRepo;
	
	 @Test
	 public void testFindByPackageName()throws Exception{
		 
		 String date="15/04/2017";  
		 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		 VideoPackage videoPackage = new VideoPackage();
		 videoPackage.setPackageId(null);
		 videoPackage.setPackageName("package 01A");
		 videoPackage.setValidFrom(date1);
		 videoPackage.setValidTill(30);
		 
		 entityManager.persist(videoPackage);
		 
		 VideoPackage pack = videoPackRepo.findByPackageName("package 01A");
		 Assert.assertNotNull(pack);
		 Assert.assertEquals("package 01A", pack.getPackageName());
		 
	 }

}
