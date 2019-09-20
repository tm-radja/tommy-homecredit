package com.tommy.manik.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tommy.manik.entity.ModulesEntity;
import com.tommy.manik.entity.RoleModulesEntity;
import com.tommy.manik.entity.User;
import com.tommy.manik.entity.UserRole;
@Repository
public class UserDaoImp implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	  
	public void addUser(User user) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		  session.save(user); 
	}

	public List<User> getUser() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<User> list= session.createCriteria(User.class).list();
		return list;
	}

	@Override
	public User findById(int id) {
		User userEntity = (User) sessionFactory.getCurrentSession().getNamedQuery("GetUserById").setParameter("userId", id).uniqueResult();
		return userEntity;
		
	}

	public User update(User val, int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		User user =(User)session.get(User.class, id);
		user.setCountry(val.getCountry());
		user.setName(val.getName());
		session.update(user);
		return user;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		User user = findById(id);
		session.delete(user);
	}
	@Override
	public User updateCountry(User val, int id){
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session.load(User.class, id);
		user.setCountry(val.getCountry());
		return user;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RoleModulesEntity> getModulesByUser(int id) {
		User userEntity = (User) sessionFactory.getCurrentSession().getNamedQuery("GetUserById").setParameter("userId", id).uniqueResult();
		if(userEntity == null || userEntity.equals(null)) {
			return null;
		}else {
			UserRole uRole = userEntity.getUserRole();
			List<RoleModulesEntity> modulesEntity = sessionFactory.getCurrentSession().getNamedQuery("GetRoleModuleByUserRole").setParameter("roleId", uRole.getRoleId()).list();
			return modulesEntity;
		}
			
		
	}

}
