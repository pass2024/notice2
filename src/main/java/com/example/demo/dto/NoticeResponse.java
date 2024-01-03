package com.example.demo.dto;

import com.example.demo.entity.Notice;

import lombok.Getter;

@Getter
public class NoticeResponse {
	
	private final String title;
	private final String content;
	
	public NoticeResponse(Notice notice) {
		this.title=notice.getTitle();
		this.content = notice.getContent();
	}
}
