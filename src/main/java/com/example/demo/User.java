package com.example.demo;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User implements Serializable {

	static final long serialVersionUID = 1L;

	private Long id;

	private String firstName;

	private String lastName;

	private String username;

	private String email;

	private Long defaultProjectId;

	private boolean isEnabled;

	private boolean isLocked;

	private String preferredTimezone;

	private Set<Role> roles;

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final User user = (User) o;
		return !(id != null ? !id.equals(user.id) : user.id != null);
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

}
