package com.shopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.Service.OrderListService;

@RestController
public class OrderListController {
	
	@Autowired
	private OrderListService orderListService;

}
