package com.example.demo.security.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MyRole {
	USER("일반유저"),//0
	ADMIN("관리자");//1
	
	private final String roleName;
}