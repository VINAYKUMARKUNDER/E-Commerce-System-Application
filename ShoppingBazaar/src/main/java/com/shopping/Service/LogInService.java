package com.shopping.Service;

import com.shopping.Exception.LogInException;
import com.shopping.model.Login;

public interface LogInService {

    public String UserlogInService (Login logdto) throws LogInException;
	public String UserlogOutService (String Key) throws LogInException;
	
	public String AdminlogInService (Login logdto) throws LogInException;
	public String AdminlogOutService (String Key) throws LogInException;
}
