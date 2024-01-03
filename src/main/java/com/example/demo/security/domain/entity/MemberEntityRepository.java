package com.example.demo.security.domain.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long>{

	Optional<MemberEntity> findByEmail(String email);


	

}
