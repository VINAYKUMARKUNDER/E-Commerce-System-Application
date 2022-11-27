package com.shopping.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Exception.LogInException;
import com.shopping.Repository.AdminRepository;
import com.shopping.Repository.CurrentAdminSessionRepository;
import com.shopping.Repository.CurrentUserSessionRepository;
import com.shopping.model.Admin;
import com.shopping.model.CurrentAdminSession;
import com.shopping.model.CurrentUserSession;
import com.shopping.model.Login;

import net.bytebuddy.utility.RandomString;

@Service
public class CurrentAdminSessionServiceImpl implements CurentAdminSessionService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CurrentAdminSessionRepository currentAdminSessionRepository;
	
	
	@Override
	public String AdminlogInService(Login logdto) throws LogInException {
		List<Admin>  admin= adminRepository.findByAdminEmail(logdto.getEmail());
		Admin existingAdmin = admin.get(0);
		if(existingAdmin == null) {
			throw new LogInException("Wrong input!! Please Enter a valid mobile number...");
		}
		
		Optional<CurrentAdminSession> validAdminSessionOpt =  currentAdminSessionRepository.findByUserId(existingAdmin.getAdminId());
		
		if(validAdminSessionOpt.isPresent()) {	
			throw new LogInException("Already Logged In...");
		}
		
		if(existingAdmin.getPassword().equals(logdto.getPassword())) {
			String key= RandomString.make(8);
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminId(),key,LocalDateTime.now());
			currentAdminSessionRepository.save(currentAdminSession);
			return currentAdminSession.toString();
		}
		else
			throw new LogInException("Please Enter a valid password");
	}
	
	
	

	@Override
	public String AdminlogOutService(String key) throws LogInException {
		CurrentAdminSession validAdminSession = currentAdminSessionRepository.findByUuid(key);
		if(validAdminSession == null) {
			throw new LogInException("Wrong Unique User Id !! Try again..");
			
		}
		currentAdminSessionRepository.delete(validAdminSession);
		return "You are Logged Out !";
	}



}
