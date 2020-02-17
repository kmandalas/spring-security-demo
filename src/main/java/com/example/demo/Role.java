package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Role implements Serializable {

	static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	/**
	 * Defines if a role is eligible for project switching within the application.
	 */
	private boolean projectSwitch;

	/**
	 * Defines if a role is eligible for access to all project categories.
	 */
	private boolean unlimitedCategories;

}
