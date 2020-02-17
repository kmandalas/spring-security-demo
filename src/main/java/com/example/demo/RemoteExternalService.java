package com.example.demo;

/**
 * Simulates an external, remote service which is used for the actual authentication and would be normally called via REST or other protocol
 */
public interface RemoteExternalService {

	/**
	 * Submits call for user login to an external system
	 *
	 * @param email the user identifier e.g. username or email
	 * @param password the password
	 * @return a custom {@link User} object simulating the response from the external system
	 */
	User authenticate(String email, String password);

}
