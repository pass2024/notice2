package com.example.demo.security.domain.entity;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SequenceGenerator(name = "gen_seq_mem",
		sequenceName = "seq_mem", initialValue = 1, allocationSize = 1)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
@Entity
public class MemberEntity extends BaseEntity{
	
	@Id 
	@GeneratedValue(generator = "gen_seq_mem", strategy = GenerationType.SEQUENCE)
	private long no;
	@Column(nullable = false, unique = true)
	private String JEmail;
	@Column(nullable = false)
	private String JPassword;//암호화해서 저장해야함
	@Column(nullable = false)
	private String Jname;
	@Column(nullable=false)
	private String JPhonenum;
	@Column(nullable=false)
	private String JBirthdate;
	@Column(nullable=false)
	private String JNickname;
	
	
	//role
	@Builder.Default
	//@Enumerated 선언하지 않으면 ordinal(숫자)로 저장됨
	@Enumerated(EnumType.STRING)//DB에 저장유형을 문자로저장
	@CollectionTable(name = "role")
	@ElementCollection(fetch = FetchType.EAGER)//1:N MemberEntity에서만 접근가능한 내장테이블
	private Set<MyRole> roles=new HashSet<>();
	//편의메서드
	public MemberEntity addRole(MyRole role) {
		roles.add(role);
		return this;
	}

}

