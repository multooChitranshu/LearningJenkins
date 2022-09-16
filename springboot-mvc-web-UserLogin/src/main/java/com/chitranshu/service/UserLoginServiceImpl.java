package com.chitranshu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitranshu.bean.User;
import com.chitranshu.persistence.UserLoginDao;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	UserLoginDao userLoginDaoImpl;

	@Override
	public boolean authenticateUser(String name, String password) {
		User user=userLoginDaoImpl.searchUser(name);
		if(user!=null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}
