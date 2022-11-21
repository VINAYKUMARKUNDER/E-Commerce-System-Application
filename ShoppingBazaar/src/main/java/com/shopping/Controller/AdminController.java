package com.shopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.Service.AdminService;
import com.shopping.model.Admin;
import com.shopping.model.Product;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
		Admin ad= adminService.addAdmin(admin);
		return new ResponseEntity<Admin>(ad,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product pr= adminService.addProduct(product);
		return new ResponseEntity<Product>(pr,HttpStatus.ACCEPTED);
	}

}
