package com.example.demo;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MyUserDetailsService extends UserDetailsService {

	UserDetails loadUserByUsernamePassword(String email, String password) throws AuthenticationException;

}
