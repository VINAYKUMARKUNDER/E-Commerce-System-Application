package com.shopping.Service;

import com.shopping.Exception.LogInException;
import com.shopping.model.Login;

public interface CurentAdminSessionService {
	public String AdminlogInService (Login logdto) throws LogInException;
	public String AdminlogOutService (String Key) throws LogInException;

}
