package com.example.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.demo.dto.NoticeDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Notice {

		@Id
		@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
		private Long id;

		@Column(nullable = false)
		private String title;

		@Column(nullable = false)
		private String content;

		@CreationTimestamp
		private LocalDateTime createdDate;

		@UpdateTimestamp
		private LocalDateTime updatedDate;

		private int readCount; // 조회수 0

		boolean isLock; // 게시글잠금여부 false

		public Notice(String title, String content) {
			this.title=title;
			this.content=content;
		}
		
		public void update(String title, String content) {
			this.title=title;
			this.content=content;
		}
}
