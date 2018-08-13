package com.zj.Test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.zj.Service.UserService;
import com.zj.entities.User;

public class Usertest extends SpringTestBase{
	@Autowired
	private UserService service;
	Logger logger=LoggerFactory.getLogger(Usertest.class);
	
	@Test
	public void SelectUser(){
		User user=service.selectUserByid(2);
		System.out.println(user);
		logger.debug("²éÕÒ½á¹û"+user);
	}
	
}
