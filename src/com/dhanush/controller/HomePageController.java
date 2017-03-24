package com.dhanush.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.dhanush.domain.EquipmentType;
import com.dhanush.domain.Facility;
import com.dhanush.domain.User;
import com.dhanush.services.UserService;

@Controller
public class HomePageController {

	@Autowired
	UserService userService;
	
	
	public HomePageController(UserService userService) {
		// TODO Auto-generated constructor stub
		this.userService = userService;
	}

	@RequestMapping("/register")
	public ModelAndView registerUser(@ModelAttribute User user) {
		List<String> typeList = new ArrayList<String>();
		 List<String> facilitylistt = new ArrayList<String>();
		List<EquipmentType> userList = userService.getEquipmentTypeList();
		List<Facility> facilityList=userService.getFacilityMasterList();
System.out.println("Equipment Type List: " +userList.get(0).getNAME());
	for(int i =0;i<userList.size(); i++){
		typeList.add(userList.get(i).getNAME());
	}
	System.out.println("Facility List: " +facilityList.get(0).getEquipment_Name());
	 for(int i =0;i<facilityList.size(); i++){
	  facilitylistt.add(facilityList.get(i).getEquipment_Name());
	 }
	Map<String, List> map = new HashMap<String, List>();
		map.put("typeList", typeList);
		map.put("facilitylistt", facilitylistt);
		return new ModelAndView("register", "map", map);
	}

	@RequestMapping("/insert")
	
	public String inserData(@ModelAttribute User user) {
		System.out.println("entering the value");
		System.out.println("Insert request invoked"+user.getEquipment_Id());
		System.out.println("Insert request invoked"+user.getEquipment_Name());
		System.out.println("Insert request invoked"+user.getStart_Date());
		System.out.println("controller here");
		if (user != null)
			System.out.println("Insert request invoked1");
			userService.insertData(user);
			System.out.println("Insert request invoked2");
		return "redirect:/getList";
	}
@RequestMapping("/getList")
	public ModelAndView getUserLIst() {
	System.out.println("First Enter 6");
		List<User> userList = userService.getUserList();
		System.out.println("First Enter 7");
		System.out.println("UserList: "+userList);
		System.out.println("First Enter 8");
		return new ModelAndView("userList", "userList", userList);
	}


	/*@RequestMapping("/update")
	public String updateUser(@ModelAttribute User user) {
		userService.updateData(user);
		return "redirect:/getList";

	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam String id) {
		System.out.println("id = " + id);
		userService.deleteData(id);
		return "redirect:/getList";
	}
	*/
	
}