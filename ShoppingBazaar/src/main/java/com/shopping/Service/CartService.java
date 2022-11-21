package com.shopping.Service;

import com.shopping.Exception.CartException;
import com.shopping.Exception.CustomerException;
import com.shopping.Exception.ProductException;
import com.shopping.model.Product;

public interface CartService {
	
	public Product AddProductCart(String key,Integer productId)throws ProductException,CustomerException;
	public Integer totalAmount(String key)throws CartException,CustomerException;
	public Product deleteProductToCart(String key,Integer productId)throws CartException,CustomerException;
	public Product increaseProductQuantity(String key,Integer productId, Integer increaseValue)throws CartException,CustomerException;

}
