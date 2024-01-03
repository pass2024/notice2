package com.example.demo.security.real;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {
	// 인증을 위한 도메인과 리포지터리, 서비스 완성, 실제 인증 처리를 하는 시큐리티 설정파일을 만든다.
	private final UserDetailService userDetailService;
	
	//스프링 시큐리티 기능 비활성화
	@Bean
	public WebSecurityCustomizer configute() {
		return (web) -> web.ignoring()
				.requestMatchers("오라클드라이버?")
				.requestMatchers("/static/**");
	}
	
	@Bean
	public SecurityFilterChain<HttpSecurity> filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeRequests()
				.requestMatchers("/login", "/signup", "/user").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/notices")
				.and()
				.logout()
				.logoutSuccessUrl(null)
				.and()
				.logout()
				.logoutSuccessUrl(null)
				.invalidateHttpSession(true)
				.and()
				.csrf().disable()
				.build()
	}
}
