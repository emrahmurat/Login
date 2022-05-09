package com.tickets.login.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tickets.login.dao.UserDao;
import com.tickets.login.entities.UserEntity;
import com.tickets.login.model.dto.UserDto;
import com.tickets.login.model.dto.UserLoginDto;
import com.tickets.login.service.repository.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserServiceImpl(UserDao userDao) {
		
		super();
		this.userDao = userDao;
	}

	@Override
	public Boolean loginUser(UserLoginDto user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		String email = userEntity.getEmail();
		
		Boolean state;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
		
		if(encoder.matches(user.getPassword(), this.userDao.findByPassword(email)) == true) {
			state = true;
		}
		else {
			state = false;
		}
		return state;
	}

	@Override
	public UserDto createUser(UserDto user) {
		UserEntity userEntity = new UserEntity();
		UserDto returnValue = new UserDto();
		UserEntity storedByData = new UserEntity();
		String password = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(password);
		BeanUtils.copyProperties(user, userEntity);
		
		storedByData = this.userDao.save(userEntity);
		
		BeanUtils.copyProperties(storedByData, returnValue);
		return returnValue;
	}

	@Override
	public String deleteUser(int id) {

		String state;
		try {
		
			 this.userDao.deleteById(id);
			 state = "silme işlemi başarılı";
		}
	
		catch (Exception e) {
			state = "silme işlemi başarısız";
			System.out.println("hata kodu"+e.getMessage());
		}
		return state;
	}

	@Override
	public List<UserEntity> getAll() {

		List<UserEntity> returnValue = this.userDao.findAll();
		return returnValue;
		
	}

}
