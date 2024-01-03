package com.example.demo.security.domain.entity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(14);
	}
	//*
	@Bean
	MyUserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}
	//*/
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			//url 보안설정
			//.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(authorize->authorize
				.antMatchers("/css/**","/images/**","/js/**").permitAll()//static자원들 인증없이 접근가능
				.antMatchers("/","/login","join").permitAll()//인증없이 접근가능
				.antMatchers("/user/**").hasAnyRole("USER")
				.antMatchers("/admin/**").hasAnyRole("ADMIN")
				.anyRequest().authenticated()//나머지는 인증(로그인)해야해요
				)
			//로그인페이지 설정
			
			.formLogin(formLogin->formLogin
				.loginPage("/login")//get
				//.loginProcessingUrl("/signin-process")//post: 적용안하면 loginPage랑 동일
				.usernameParameter("JEmail")//default:username--form
				.passwordParameter("JPassword")//default:password--form
				.permitAll()
				)
			//	*/
		;

		return http.build();
	}
}
