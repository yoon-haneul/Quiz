package com.example.demo.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/register") 
	public String signup(Model model) {
	model.addAttribute("userDTO", new UserDto());
	return "signup";
	}
	
	@PostMapping("/register")
	public String signup(@Valid UserDto userDto, 
			BindingResult bindingResult) throws Exception {
		
		if(bindingResult.hasErrors()) {
			return "signup";
		}
		this.userService.signup(userDto);
		return"redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
	return"login";	
	}

}
