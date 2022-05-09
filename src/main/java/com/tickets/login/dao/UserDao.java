package com.tickets.login.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tickets.login.entities.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer> {
	
	@Query(value = "SELECT password FROM users where email = :email ",nativeQuery = true)
	String findByPassword(@Param("email")String email);
	
	@Query(value="SELECT * FROM users" , nativeQuery = true)
	List<UserEntity> getAll();

}
