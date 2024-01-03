package com.example.demo.security.real;

import org.glassfish.jaxb.core.v2.runtime.IllegalAnnotationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	// 스프링 시큐리티에서 사용자 정보를 가져오는 userdetailservice인터페이스를 구현한다.
	// 필수로 구현해야 하는 loadUserByUsername 메서드를 오버라이딩해서 사용자 정보를 가져오는 로긱을 작성한다.

	@Override
	public User loadUserByUsername(String id) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(id)
				.orElseThrow(()->new IllegalArgumentException(id));
	}

}
