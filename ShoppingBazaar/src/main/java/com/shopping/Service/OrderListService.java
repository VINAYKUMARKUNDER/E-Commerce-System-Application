package com.shopping.Service;

import java.util.List;

import com.shopping.Exception.CartException;
import com.shopping.Exception.OrderListException;
import com.shopping.Exception.ProductException;
import com.shopping.model.Product;

public interface OrderListService {
	
	public List<Product> addCartToOrderList(List<Product> products)throws ProductException,CartException,OrderListException;

}
