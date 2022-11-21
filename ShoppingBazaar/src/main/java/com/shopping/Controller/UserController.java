package com.shopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

}
