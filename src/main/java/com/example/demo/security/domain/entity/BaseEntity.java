package com.example.demo.security.domain.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class BaseEntity {
	
	@CreationTimestamp
	private LocalDateTime createdDate;//생성일
	@UpdateTimestamp
	private LocalDateTime updatedDate;//수정일
}
