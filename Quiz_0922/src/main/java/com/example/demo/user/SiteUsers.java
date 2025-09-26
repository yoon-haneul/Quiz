package com.example.demo.user;

import groovy.transform.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor
public class SiteUsers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	
	@Column(unique=true, nullable=false)
	private String username;
	@Column(nullable=false)
	private String nickname;
	@Column(nullable=false)
	private String password;
	@Enumerated(EnumType.STRING)
	private UserCharacter characterType;
	@Enumerated(EnumType.STRING)
	private UserRole userRole; 

	
	public SiteUsers(String username, String nickname, String password, 
			UserCharacter characterType) {

		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.characterType = characterType;
		this.userRole = UserRole.USER;

	}
	
	
}

	









