package com.example.demo.user;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public void signup(@Valid UserDto userDto) throws Exception {
		if(!userDto.getPassword().equals(userDto.getConfirmPassword()) | userDto.isTermsAgreed()==false) {
			throw new Exception("회원가입을 진행할 수 없습니다.");
		}
		SiteUsers user = new SiteUsers(
				userDto.getUsername(),
				userDto.getNickname(),
				userDto.getPassword(),
				userDto.getCharacterType()
				);
		
		this.userRepository.save(user);
		
	}
	

	

	
	
}
