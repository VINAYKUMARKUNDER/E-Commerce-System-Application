package com.shopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.Exception.LogInException;
import com.shopping.Service.LogInService;
import com.shopping.model.Login;

@RestController
public class LoginController {
	
	@Autowired
	private LogInService logService;
	
	@PostMapping("/userLogIn")
	public ResponseEntity<String> UserlogInService(@RequestBody Login logdto) throws LogInException{
		String output = logService.UserlogInService(logdto);
		return new ResponseEntity<String>(output,HttpStatus.OK);
	}
	
	@PostMapping("/userLogOut")
	public ResponseEntity<String> UserlogOutService(@RequestParam String key) throws LogInException{
		
		String output = logService.UserlogOutService(key);
		
		return new ResponseEntity<String>(output,HttpStatus.OK);
	}
	
	
	@PostMapping("/AdminLogIn")
	public ResponseEntity<String> AdminlogInService(@RequestBody Login logdto) throws LogInException{
		String output = logService.AdminlogInService(logdto);
		return new ResponseEntity<String>(output,HttpStatus.OK);
	}
	
	@PostMapping("/AdminLogOut")
	public ResponseEntity<String> AdminlogOutService(@RequestParam String key) throws LogInException{
		
		String output = logService.AdminlogOutService(key);
		
		return new ResponseEntity<String>(output,HttpStatus.OK);
	}

}
