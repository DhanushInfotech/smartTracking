package com.dhanush.services;

import java.util.List;
import com.dhanush.domain.EquipmentType;
import com.dhanush.domain.Facility;
import com.dhanush.domain.User;

public interface UserService {
public void insertData(User user);

	public List<User> getUserList();

	//public void deleteData(String id);

	public User getUser(String id);

	//public void updateData(User user);
	public List<EquipmentType> getEquipmentTypeList();
	public List<Facility> getFacilityMasterList();
}
