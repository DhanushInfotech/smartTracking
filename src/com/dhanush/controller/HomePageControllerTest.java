package com.dhanush.controller;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dhanush.dao.UserDao;
import com.dhanush.dao.UserDaoImpl;
import com.dhanush.domain.User;
import com.dhanush.services.UserService;
import com.dhanush.services.UserServiceImpl;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-servlet.xml"})
//@ContextConfiguration("../../../smartTracking/WebContent/WEB-INF/spring-servlet.xml")
@ActiveProfiles("test")

public class HomePageControllerTest {
	@Autowired(required=false)
	DataSource dataSource;
	private UserService userservice;
	
	private UserDao userdao;	
	private User user;
	
	/*@Test
	public void testRegisterUser() {
		fail("Not yet implemented");
	}*/
	 protected void setUp() throws Exception {
	Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?user=root&password=root");
	     
	    }    
	
	@Test
	public void testInserData() {
		dataSource = new DriverManagerDataSource();
		userdao = new UserDaoImpl(dataSource);
		userservice = new UserServiceImpl(userdao);
		HomePageController home=new HomePageController(userservice);
		user = new User();
		 Date d = new Date(2014/03/01);
		user.setEquipment_Id(1002);
		user.setEquipment_Name("hello");
		user.setEquipment_Type_Name("facility");
		user.setFacility_Name("testing");
		user.setReg_No(110);
		user.setS_NO(113);
		user.setStart_Date(d);
		user.setEnd_Date(d);
		user.setDescription("ok");
		//when(home.inserData(user)).thenReturn("redirect:/getList");
		String str=home.inserData(user);
		assertEquals("redirect:/getList",str);
	
	}

	/*@Test
	public void testGetUserLIst() {
		fail("Not yet implemented");
	}*/

}
