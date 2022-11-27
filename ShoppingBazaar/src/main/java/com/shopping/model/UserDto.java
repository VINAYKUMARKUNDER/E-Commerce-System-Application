package com.shopping.model;

import lombok.Data;

@Data
public class UserDto {
	private Integer userId;
	private String userName;
	private String userEmail;
	private String password;

}
