package com.tickets.login.service.repository;

import java.util.List;

import com.tickets.login.entities.UserEntity;
import com.tickets.login.model.dto.UserDto;
import com.tickets.login.model.dto.UserLoginDto;

public interface UserService {

	public Boolean loginUser(UserLoginDto user);
	public UserDto createUser(UserDto user);
	public String deleteUser(int id);
	public List<UserEntity> getAll();
}
