package com.shopping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Exception.CartException;
import com.shopping.Exception.CustomerException;
import com.shopping.Exception.ProductException;
import com.shopping.Repository.CartRepository;
import com.shopping.Repository.CurrentSessionDao;
import com.shopping.Repository.ProductRepository;
import com.shopping.model.Cart;
import com.shopping.model.CurrentUserSession;
import com.shopping.model.Product;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CurrentSessionDao currentSessionDao;

	@Override
	public Product AddProductCart(String key,Integer productId) throws ProductException,CustomerException {
		
		CurrentUserSession currUser=currentSessionDao.findByUuid(key);
		if(currUser==null) throw new CustomerException("Please Login first");
		
		
		Optional<Product> pro = productRepository.findById(productId);
		if(!pro.isPresent())throw new ProductException("Product Id Invalid..");
		
		Cart cart = new Cart();
		cart.setCartId(pro.get().getProductId());
		cart.setProduct(pro.get());
		cartRepository.save(cart);
		return pro.get();
	}

	
	
	@Override
	public Integer totalAmount(String key) throws CartException,CustomerException {
		
		CurrentUserSession currUser=currentSessionDao.findByUuid(key);
		if(currUser==null) throw new CustomerException("Please Login first");
		
		
		List<Cart> listOfCarts = cartRepository.findAll();
		if(listOfCarts.size()==0)throw new CartException("Cart is empty.");
		
		Integer amount=0;
		for(Cart cart:listOfCarts)amount+=cart.getProduct().getPrice();
		return amount;
	}



	@Override
	public Product deleteProductToCart(String key,Integer productId) throws CartException,CustomerException {
		CurrentUserSession currUser=currentSessionDao.findByUuid(key);
		if(currUser==null) throw new CustomerException("Please Login first");
		
		
	Optional<Cart> cart=	cartRepository.findById(productId);
	if(!cart.isPresent())throw new CartException("Data Not Found..");
		cartRepository.deleteById(productId);
		return cart.get().getProduct();
	}



	@Override
	public Product increaseProductQuantity(String key,Integer productId, Integer increaseValue) throws CartException,CustomerException {
		CurrentUserSession currUser=currentSessionDao.findByUuid(key);
		if(currUser==null) throw new CustomerException("Please Login first");
		
		Optional<Cart> car=	cartRepository.findById(productId);
		if(!car.isPresent())throw new CartException("Data Not Found..");
		
		for(int i=0;i<increaseValue;i++) {
		Cart cart = new Cart();
		cart.setCartId(car.get().getProduct().getProductId());
		cart.setProduct(car.get().getProduct());
		cartRepository.save(cart);
		}
		return car.get().getProduct();
	}
	

}
