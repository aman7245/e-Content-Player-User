package com.project.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.user.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{

	public List<Video> findByTopicTopicId(long id);
	
}
