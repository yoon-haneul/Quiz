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
//	@Column(nullable=false)
//	private String confirmPassword;
	@Enumerated(EnumType.STRING)
	private UserCharacter characterType;
//	@Column
//	private boolean termsAgreed;
	
	public SiteUsers(String username, String nickname, String password, 
			UserCharacter characterType) {

		this.username = username;
		this.nickname = nickname;
		this.password = password;
//		this.confirmPassword = confirmPassword;
		this.characterType = characterType;
//		this.termsAgreed = termsAgreed;
	}
	
	
}

	









