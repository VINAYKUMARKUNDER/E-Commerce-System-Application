package com.shopping.Service;

import java.util.List;

import com.shopping.Exception.CustomerException;
import com.shopping.Exception.ProductException;
import com.shopping.model.Product;

public interface ProductService {
	
	public Product addProduct(String key,Product product)throws CustomerException ;
	
	public List<Product> viewProductByAdmin(String key)throws ProductException,CustomerException;
	
	public Product viewProductById(String key,Integer productId)throws ProductException,CustomerException;


    public List<Product> viewProductByUser(String key)throws ProductException,CustomerException;
	
	public List<Product> viewProductByType(String key,String productType)throws ProductException,CustomerException;

	public List<Product> viewProductByName(String key,String productName)throws ProductException,CustomerException;

	public List<Product> viewProductByBetweenToPrice(String key,Integer price1,Integer price2)throws ProductException,CustomerException;


}
