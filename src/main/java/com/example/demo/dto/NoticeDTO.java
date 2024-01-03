package com.example.demo.dto;

import com.example.demo.entity.Notice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NoticeDTO {
	
	private String title;
	private String content;
	
	public Notice toEntity() {
		return Notice.builder()
				.title(title)
				.content(content)
				.build();
	}
}
