package com.shopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.Service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

}
