package com.app.SpringbootWithAJAX.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.SpringbootWithAJAX.entity.User;
import com.app.SpringbootWithAJAX.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserRepository userRepository ;

	@Override
	public User saveUser(String name,String email,String address) {

		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setAddress(address);
		userRepository.save(user);
		
		return user;
	}

	@Override
	public List<User> getAllUsers() {

		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public void deleteUser(int userId) {

		User user = userRepository.findOne(userId);
		
		userRepository.delete(user);
		
		
	}

	@Override
	public User updateUser(int userId, String name, String email, String address) {

		User dbuser = userRepository.findOne(userId);
		User user	=null;
		if(null!=dbuser) {
			dbuser.setName(name);
			dbuser.setAddress(address);
			dbuser.setEmail(email);
			
			user	= userRepository.save(dbuser);
			
		}
		
		return user;
	}
	
	

}
