package com.project.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.user.entity.VideoPackage;
import com.project.user.repository.VideoPackageRepository;

@Service
public class VideoPackageServiceImpl implements VideoPackageService{

	private VideoPackageRepository videoPackRepo;
	
	@Autowired
	public VideoPackageServiceImpl(VideoPackageRepository videoPackRepo) {
		this.videoPackRepo = videoPackRepo;
	}
	
	@Override
	public List<VideoPackage> findAllVideoPackages() {
		List<VideoPackage> videoPackages = videoPackRepo.findAll();
		
		return videoPackages;
	}
	@Override
	public VideoPackage findPackageById(long id) {
		VideoPackage pack = videoPackRepo.findOne(id);
		return pack;
	}

}
