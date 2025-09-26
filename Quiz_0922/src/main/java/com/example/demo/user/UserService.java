package com.example.demo.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	
	
	public void signup(@Valid UserDto userDto) throws Exception {
		if(!userDto.getPassword().equals(userDto.getConfirmPassword()) | userDto.isTermsAgreed()==false) {
			throw new Exception("회원가입을 진행할 수 없습니다.");
		}
		//String getPassword = passwordEncoder.encode(userDto.getPassword()); 비밀번호 암호화 처리로 추가 및 주석처리해놨습니다
		
		SiteUsers user = new SiteUsers(
				userDto.getUsername(),
				userDto.getNickname(),
				passwordEncoder.encode(userDto.getPassword()),
				//getPassword, // 비밀번호 암호화 사용시 사용할 변수
				userDto.getCharacterType()
				);
		
		this.userRepository.save(user);
		
	}
	

	

	
	
}
