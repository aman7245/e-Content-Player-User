package com.project.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.user.entity.VideoPackage;

@Repository
public interface VideoPackageRepository extends JpaRepository<VideoPackage, Long>{

	public VideoPackage findByPackageName(String packageName);
	
}
