package com.example.demo.dto;

import com.example.demo.entity.Notice;
import com.example.demo.entity.Qna;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QnaDTO {

	private String title;
	private String content;
	
	public Qna toEntity() {
		return Qna.builder()
				.title(title)
				.content(content)
				.build();
	}
}
