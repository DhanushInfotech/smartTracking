package com.dhanush.dao;

import java.util.List;
import com.dhanush.domain.EquipmentType;
import com.dhanush.domain.Facility;
import com.dhanush.domain.User;

public interface UserDao {
	public void insertData(User user);

	public List<User> getUserList();

	/*public void updateData(User user);

	public void deleteData(String id);*/

	public User getUser(String id);
	public List<EquipmentType> getEquipmentTypeList();
	public List<Facility> getFacilityMasterList();
	

}
