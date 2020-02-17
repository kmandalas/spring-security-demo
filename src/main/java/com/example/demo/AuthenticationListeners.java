package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class AuthenticationListeners {

	@EventListener
	public void authSuccessEventListener(AuthenticationSuccessEvent authorizedEvent) {
		// write custom code here for login success audit
		// note: tha the first event must be skipped, we do have info to acknowledge that
		System.out.println("--------------------------- User Oauth2 login success ------------------------------");
		System.out.println("This is success event : " + authorizedEvent.getAuthentication().getPrincipal());
	}

	@EventListener
	public void authFailedEventListener(AbstractAuthenticationFailureEvent oAuth2AuthenticationFailureEvent) {
		// write custom code here login failed audit.
		System.out.println("--------------------------- User Oauth2 login Failed -------------------------------");
		System.out.println(oAuth2AuthenticationFailureEvent.getAuthentication().getPrincipal());
	}

}

