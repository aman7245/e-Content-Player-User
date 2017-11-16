package com.project.user.service;

import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.project.user.EContentPlayerUserApplicationTests;
import com.project.user.entity.VideoPackage;
import com.project.user.repository.VideoPackageRepository;

@Transactional
public class TestVideoPackageService extends EContentPlayerUserApplicationTests{

	private VideoPackageServiceImpl packageserv;

	private VideoPackageRepository videoPackRepo;
	
	@Before
	public void setUp(){
		videoPackRepo = Mockito.mock(VideoPackageRepository.class);
		packageserv = new VideoPackageServiceImpl(videoPackRepo);
	}
	
	@Test
	public void testFindAllPackages() throws Exception{
		String date="31/03/2017";  
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		VideoPackage packages = new VideoPackage();
		packages.setPackageId("PACK01A");
		packages.setPackageName("package 01A");
		packages.setValidFrom(date1);
		packages.setValidTill(30);
		List<VideoPackage> packageList = new ArrayList<>();
		packageList.add(packages);
		
		when(videoPackRepo.findAll()).thenReturn(packageList);
		
		List<VideoPackage> list = packageserv.findAllVideoPackages();
		Assert.assertNotNull("Expected not null", list);
		Assert.assertEquals("Expected Size", 1, list.size());
		
	}
	
	@Test
	public void testFindByID(){
		String name = "package11";
		VideoPackage pack = new VideoPackage();
		pack.setId(1L);
		pack.setPackageName(name);
		
		when(videoPackRepo.findOne(1L)).thenReturn(pack);
		
		VideoPackage packages = packageserv.findPackageById(1L); 
		Assert.assertNotNull("Expected Not NULL", packages);
		Assert.assertEquals("Expected ID attribute match", 1L, packages.getId());
		
	}
	
	@Test
	public void testFindByIdNotFound(){
		String name = "package11";
		VideoPackage pack = new VideoPackage();
		pack.setId(1L);
		pack.setPackageName(name);
		when(videoPackRepo.findOne(1L)).thenReturn(pack);
		Long id = Long.MAX_VALUE;
		VideoPackage packages = packageserv.findPackageById(id);
		Assert.assertNull("Expected NULL", packages);
		
	}
}
