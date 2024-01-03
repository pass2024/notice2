package com.example.demo.dto;

import com.example.demo.entity.Qna;

import lombok.Getter;

@Getter
public class QnaResponse {

	private final String title;
	private final String content;
	
	public QnaResponse(Qna qna) {
		this.title=qna.getTitle();
		this.content = qna.getContent();
	}
}
