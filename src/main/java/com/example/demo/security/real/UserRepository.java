package com.example.demo.security.real;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
	Optional<User> findByEmail(String email);
	
	// 사용자 정보를 가져오기 위해서는 스프링 시큐리티가 이메일을 전달받아야한다.
	// 스프링데이터jpa는 메서드규칙에 맞춰 메서드를 선언하면 이름을 분석해 자동으로 쿼리를 생성해준다.
	
}
