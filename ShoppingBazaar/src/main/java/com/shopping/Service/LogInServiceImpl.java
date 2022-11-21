package com.shopping.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.random.RandomGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Exception.LogInException;
import com.shopping.Repository.AdminRepository;
import com.shopping.Repository.CurrentSessionDao;
import com.shopping.Repository.UserRepository;
import com.shopping.model.Admin;
import com.shopping.model.CurrentUserSession;
import com.shopping.model.Login;
import com.shopping.model.User;

import net.bytebuddy.utility.RandomString;

@Service
public class LogInServiceImpl implements LogInService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CurrentSessionDao sDao;
	
	

	@Override
	public String UserlogInService(Login logdto) throws LogInException {
		List<User> user= userRepository.findByUserEmail(logdto.getEmail());
		User existingUser = user.get(0);
		if(existingUser == null) {
			throw new LogInException("Wrong input!! Please Enter a valid mobile number...");
		}
		
		Optional<CurrentUserSession> validUserSessionOpt =  sDao.findByUserId(existingUser.getUserId());
		
		if(validUserSessionOpt.isPresent()) {	
			throw new LogInException("Already Logged In...");
		}
		
		if(existingUser.getPassword().equals(logdto.getPassword())) {
			String key= RandomString.make(8);
			CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getUserId(),key,LocalDateTime.now());
			sDao.save(currentUserSession);
			return currentUserSession.toString();
		}
		else
			throw new LogInException("Please Enter a valid password");
	}
	
	
	

	@Override
	public String UserlogOutService(String key) throws LogInException {

		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		
		if(validCustomerSession == null) {
			throw new LogInException("Wrong Unique User Id !! Try again..");
			
		}
		
		sDao.delete(validCustomerSession);
		
		return "You are Logged Out !";
	}
	
	
	
	
	
	
	@Override
	public String AdminlogInService(Login logdto) throws LogInException {
		List<Admin>  admin= adminRepository.findByAdminEmail(logdto.getEmail());
		Admin existingAdmin = admin.get(0);
		if(existingAdmin == null) {
			throw new LogInException("Wrong input!! Please Enter a valid mobile number...");
		}
		
		Optional<CurrentUserSession> validUserSessionOpt =  sDao.findByUserId(existingAdmin.getAdminId());
		
		if(validUserSessionOpt.isPresent()) {	
			throw new LogInException("Already Logged In...");
		}
		
		if(existingAdmin.getPassword().equals(logdto.getPassword())) {
			String key= RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(existingAdmin.getAdminId(),key,LocalDateTime.now());
			sDao.save(currentUserSession);
			return currentUserSession.toString();
		}
		else
			throw new LogInException("Please Enter a valid password");
	}
	
	
	

	@Override
	public String AdminlogOutService(String key) throws LogInException {

		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		if(validCustomerSession == null) {
			throw new LogInException("Wrong Unique User Id !! Try again..");
			
		}
		
		sDao.delete(validCustomerSession);
		
		return "You are Logged Out !";
	}


}
