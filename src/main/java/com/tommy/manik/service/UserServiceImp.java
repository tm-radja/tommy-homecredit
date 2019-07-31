package com.tommy.manik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tommy.manik.entity.ModulesEntity;
import com.tommy.manik.entity.RoleModulesEntity;
import com.tommy.manik.entity.User;
import com.tommy.manik.dao.UserDao;

@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	UserDao userDao;


	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userDao.getUser();
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	public void createUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}
	@Override
	public User updatePartially(User user, int id) {
		userDao.updateCountry(user,id);
		return userDao.findById(id);
	}

	@Override
	public User update(User user,int id) {
		// TODO Auto-generated method stub
		return userDao.update(user, id);
	}

	@Override
	public List<RoleModulesEntity> getModulesByUser(int id) {
		// TODO Auto-generated method stub
		return userDao.getModulesByUser(id);
	}

}
