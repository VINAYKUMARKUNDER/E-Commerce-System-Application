package com.shopping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findByUserEmail(String usreEmail);
	public List<User> findByUserName(String userName);

}
