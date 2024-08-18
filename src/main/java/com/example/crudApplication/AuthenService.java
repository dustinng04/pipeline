package com.example.crudApplication;

import org.springframework.stereotype.Service;

@Service
public class AuthenService {
	public boolean authenticate(String username, String password) {
		return (username.equalsIgnoreCase("in28minutes") && password.equalsIgnoreCase("dummy"));			
	}
}
