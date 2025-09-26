package com.example.demo.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter	
@Setter
public class UserDto {

	@Size(min=4, max=20)
	@NotEmpty(message="영문,숫자 4-20자")
	private String username;
	
	@Size(min=2, max=10)
	@NotEmpty(message="2-10자 닉네임")
	private String nickname;
	
	@Size(min=6)
	@NotEmpty(message="6자 이상")
	private String password;
	
	@Size(min=6)
	@NotEmpty(message="비밀번호 재입력")
	private String confirmPassword;
	
	private UserCharacter characterType;
	private boolean termsAgreed;
}
