package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * An {@link AuthenticationProvider} implementation that retrieves user details from a {@link UserDetailsService}.
 */
@Component
@Slf4j
public class MyAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	protected MyUserDetailsService myUserDetailsService;

	/**
	 * {@inheritDoc}
	 *
	 * @see AbstractUserDetailsAuthenticationProvider#additionalAuthenticationChecks(UserDetails, UsernamePasswordAuthenticationToken)
	 */
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		// TODO: add your code here if necessary
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doAfterPropertiesSet()  {
		Assert.notNull(this.myUserDetailsService, "userService must be set");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		return myUserDetailsService.loadUserByUsernamePassword(username, authentication.getCredentials().toString());
	}

}
