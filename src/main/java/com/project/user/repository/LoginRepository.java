package com.project.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.user.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{

	public Login findByUsername(String username);
	
}
