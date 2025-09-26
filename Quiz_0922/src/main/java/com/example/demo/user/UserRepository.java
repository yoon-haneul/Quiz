package com.example.demo.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUsers, Long> {

	//Optional<SiteUsers> findByUsername(String username); //로그인 처리를 위한 회원찾기

}
