package com.example.demo.global;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration 
@EnableWebSecurity
public class Securityconfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests((authorizeHttpRequests) 
					-> authorizeHttpRequests
					.requestMatchers("/admin/**").hasRole("ADMIN") // admin권한을 가지고있는 사람들만 /admin/** 링크의 접속을 허용
					.requestMatchers(new AntPathRequestMatcher("/**")).permitAll()) // 다른 링크들은 권한요구없이 접속 허용
			.csrf((csrf) -> csrf
					.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
			  .headers((headers) -> headers
		                .addHeaderWriter(new XFrameOptionsHeaderWriter(
		                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
			  .formLogin((formLogin) -> formLogin
					  .loginPage("/login") // 로그인 링크
					  .defaultSuccessUrl("/")
					  )
			  .logout((logout) -> logout
					  .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그아웃 링크
					  .logoutSuccessUrl("/")
					  .invalidateHttpSession(true)
					  )
			  ;
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); //비밀번호 암호화 
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		// AuthenticationConfiguration : 웹 서비스(어플리케이션의)인증 설정을 캡슐화 하고 있음.
		//	-> getAuthenticationManager라는 메서드를 호출해 정보를 가져옴.
		return authenticationConfiguration.getAuthenticationManager();
	    }
	
	
}

