package com.example.demo.user;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public void signup(@Valid UserDto userDto) {
		SiteUsers user = new SiteUsers(
				userDto.getUsername(),
				userDto.getNickname(),
				userDto.getPassword(),
				userDto.getConfirmPassword(),
				userDto.getCharacterType(),
				userDto.isTermsAgreed()
				);
		
		this.userRepository.save(user);
		
	}
	

	

	
	
}
