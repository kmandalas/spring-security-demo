package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

	/**
	 * The {@link RemoteExternalService}
	 */
	@Autowired
	private RemoteExternalService userService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDetails loadUserByUsername(final String s) throws UsernameNotFoundException {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDetails loadUserByUsernamePassword(final String username, final String password) throws AuthenticationException {
		final User user;
		try {
			user = userService.authenticate(username, password);
		} catch (Exception e) {
			throw new InternalAuthenticationServiceException(e.getMessage(), e);
		}

		final List<GrantedAuthority> authorities =
				user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

		final boolean unlimitedCategoryAccess = user.getRoles().stream().anyMatch(Role::isUnlimitedCategories);

		final UserInfo userInfo = new UserInfo(user, authorities, unlimitedCategoryAccess);
		userInfo.setDefaultProjectId(user.getDefaultProjectId());

		log.info("Attempted login for user: [{}]", userInfo);
		return userInfo;
	}

}
