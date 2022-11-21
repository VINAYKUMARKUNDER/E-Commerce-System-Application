package com.shopping.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Repository.AdminRepository;
import com.shopping.Repository.ProductRepository;
import com.shopping.model.Admin;
import com.shopping.model.Product;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

}
