package com.example.demo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * The user info object implementing {@link UserDetails} with additional fields.
 */
public class UserInfo implements UserDetails {

	/** The {@link User user's} id. */
	private final Long id;

	/** The {@link User user's} username. */
	private String username;

	/** The {@link User user's} default project id */
	private Long defaultProjectId;

	/** The {@link User user's} email. */
	private final String email;

	/** The {@link User user's} is enabled. */
	private final boolean isEnabled;

	/** The {@link User user's} account non locked. */
	private final boolean isAccountNonLocked;

	/** The {@link User user's} preferred timezone. */
	private final String preferredTimezone;

	/** The {@link User user's} eligibility to access all categories. */
	private final boolean unlimitedCategoryAccess;

	/** The {@link User user's} authorities. */
	private final Collection<? extends GrantedAuthority> authorities;

	public UserInfo(final User user, final Collection authorities, final boolean unlimitedCategoryAccess) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.defaultProjectId = user.getDefaultProjectId();
		this.email = user.getEmail();
		this.isEnabled = user.isEnabled();
		this.isAccountNonLocked = !user.isLocked();
		this.preferredTimezone = user.getPreferredTimezone();
		this.authorities = authorities;
		this.unlimitedCategoryAccess = unlimitedCategoryAccess;
	}

	public Long getId() {
		return id;
	}

	public Long getDefaultProjectId() {
		return defaultProjectId;
	}

	public void setDefaultProjectId(final Long defaultProjectId) {
		this.defaultProjectId = defaultProjectId;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public String getPreferredTimezone() {
		return preferredTimezone;
	}

	public boolean isUnlimitedCategoryAccess() {
		return unlimitedCategoryAccess;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final UserInfo userInfo = (UserInfo) o;

		return !(id != null ? !id.equals(userInfo.id) : userInfo.id != null);
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UserInfo{");
		sb.append("id=").append(id);
		sb.append(", username='").append(username).append('\'');
		sb.append(", defaultProjectId=").append(defaultProjectId);
		sb.append(", email='").append(email).append('\'');
		sb.append(", isEnabled=").append(isEnabled);
		sb.append(", isAccountNonLocked=").append(isAccountNonLocked);
		sb.append(", preferredTimezone='").append(preferredTimezone).append('\'');
		sb.append(", authorities=").append(authorities);
		sb.append('}');

		return sb.toString();
	}

}