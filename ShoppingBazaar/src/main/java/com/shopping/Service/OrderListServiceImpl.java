package com.shopping.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Repository.OrderListRepository;

@Service
public class OrderListServiceImpl implements OrderListService{

		@Autowired
		private OrderListRepository orderListRepository;
}
