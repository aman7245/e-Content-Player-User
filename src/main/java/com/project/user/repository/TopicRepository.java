package com.project.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.user.entity.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>{

	public List<Topic> findByVideoPackageId(long id);
	
}
