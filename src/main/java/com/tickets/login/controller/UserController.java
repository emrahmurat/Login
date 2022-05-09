package com.tickets.login.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tickets.login.entities.UserEntity;
import com.tickets.login.model.dto.UserDto;
import com.tickets.login.model.dto.UserLoginDto;
import com.tickets.login.model.request.UserLoginRequestModel;
import com.tickets.login.model.request.UserRequestModel;
import com.tickets.login.model.response.UserRest;
import com.tickets.login.service.repository.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public Boolean loginController(@RequestBody UserLoginRequestModel loginRequestModel) {
		
		UserLoginDto userDto = new UserLoginDto();
		BeanUtils.copyProperties(loginRequestModel, userDto);
		Boolean state = this.userService.loginUser(userDto);
		
		return state;
	}
	
	@PostMapping("/create")
	public UserRest createController(@RequestBody UserRequestModel requestModel) {
		UserDto loginDto = new UserDto();
		BeanUtils.copyProperties(requestModel, loginDto);
		UserDto storedByService = this.userService.createUser(loginDto);
		UserRest returnValue = new UserRest();
		BeanUtils.copyProperties(storedByService, returnValue);
		return returnValue;
		
		
	}
	@DeleteMapping("/delete{id}")
	public String deleteController(@PathParam(value = "id") int id) {
		String islem = this.userService.deleteUser(id);
		return islem;
	}
	@GetMapping("/getAll")
	public List<UserEntity> getAll() {
		List<UserEntity> returnValue = new ArrayList<UserEntity>();
		returnValue = this.userService.getAll();
		return returnValue;
	}
	
	
	
	
	
	
	
}
