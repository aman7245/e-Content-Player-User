package com.project.user.service;

import java.util.List;

import com.project.user.entity.VideoPackage;

public interface VideoPackageService {

	public List<VideoPackage> findAllVideoPackages();
	public VideoPackage findPackageById(long id);

}
