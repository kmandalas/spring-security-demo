package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * The implementation of {@link RemoteExternalService}.
 */
@Service
@Slf4j
public class RemoteExternalServiceImpl implements RemoteExternalService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User authenticate(final String username, final String password)  {
		if (!"user".equals(username) || !"pass".equals(password)) throw new UsernameNotFoundException("Wrong credentials");

		Set<Role> roleSet = new HashSet<>();
		Role role = Role.builder().id(1L).name("ROLE_ADMIN").projectSwitch(true).unlimitedCategories(true).build();
		roleSet.add(role);

		return new User.UserBuilder()
				.id(100L)
				.email("kmandalas@aprovider.com")
				.firstName("Kyriakos")
				.lastName("Mandalas")
				.username("kmandalas")
				.defaultProjectId(1001L)
				.isEnabled(true)
				.isLocked(false)
				.preferredTimezone("GMT +2")
				.roles(roleSet)
				.build();
	}

}
