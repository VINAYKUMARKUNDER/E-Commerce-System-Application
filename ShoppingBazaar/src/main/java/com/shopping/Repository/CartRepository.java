package com.shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
