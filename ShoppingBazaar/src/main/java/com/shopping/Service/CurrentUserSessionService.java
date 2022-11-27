package com.shopping.Service;

import com.shopping.Exception.LogInException;
import com.shopping.model.Login;

public interface CurrentUserSessionService {

    public String UserlogInService (Login logdto) throws LogInException;
	public String UserlogOutService (String Key) throws LogInException;
	
	
}
