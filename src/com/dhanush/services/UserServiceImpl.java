package com.dhanush.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dhanush.dao.UserDao;
import com.dhanush.domain.EquipmentType;
import com.dhanush.domain.Facility;
import com.dhanush.domain.User;


public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	public UserServiceImpl(UserDao userDao) {
		// TODO Auto-generated constructor stub
		this.userdao = userDao;
	}
	@Override
	public void insertData(User user) {
		userdao.insertData(user);
	}

	@Override
	public List<User> getUserList() {
		return userdao.getUserList();
	}
	@Override
	public List<EquipmentType> getEquipmentTypeList() {
		return userdao.getEquipmentTypeList();
	}

/*	@Override
	public void deleteData(String id) {
		userdao.deleteData(id);
		
	}*/

	@Override
	public User getUser(String id) {
		return userdao.getUser(id);
	}

	/*@Override
	public void updateData(User user) {
		userdao.updateData(user);
		
	}*/
	@Override
	public List<Facility> getFacilityMasterList() {
		// TODO Auto-generated method stub
		 return userdao.getFacilityMasterList();
	}


	
}
