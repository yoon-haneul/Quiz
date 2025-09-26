package com.example.demo.user;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
	
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER")
	;

	private final String key;
	
}
