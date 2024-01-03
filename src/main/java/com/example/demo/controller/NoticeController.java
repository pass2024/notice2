package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.NoticeDTO;
import com.example.demo.dto.NoticeResponse;
import com.example.demo.dto.UpdateNoticeRequest;
import com.example.demo.entity.Notice;
import com.example.demo.service.NoticeService;

import lombok.RequiredArgsConstructor;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class NoticeController {

	private final NoticeService noticeService;
	
	@PostMapping("/admin/notices") // 공지사항 등록(관리자용)
	public ResponseEntity<Notice> addNotice(@RequestBody NoticeDTO dto) { 
		Notice savedNotice=noticeService.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(savedNotice);
	}
	
	@GetMapping("/admin/notices") // 공지사항 전체조회 (관리자용)
		public ResponseEntity<List<NoticeResponse>> findAllNotices() {
		List<NoticeResponse> notices=noticeService.findAll()
				.stream()
				.map(NoticeResponse::new)
				.toList();
		
		return ResponseEntity.ok()
				.body(notices);
	}
	
	@GetMapping("/admin/notices") //공지사항 한개 찾기
	public ResponseEntity<NoticeResponse> findNotice(@PathVariable long no) {
		Notice notice = noticeService.findById(no);
		
		return ResponseEntity.ok()
				.body(new NoticeResponse(notice));
	}
	
	@DeleteMapping("/notices/{noticeNo}")
	public ResponseEntity<Void> deleteNotice(@PathVariable long no){
		noticeService.delete(no);
		
		return ResponseEntity.ok()
				.build();
	}
	
	@PutMapping("notices/{noticeNo}")
	public ResponseEntity<Notice> updateNotice(@PathVariable long no, @RequestBody UpdateNoticeRequest request) {
		Notice updatedNotice = noticeService.update(no, request);
		
		return ResponseEntity.ok()
				.body(updatedNotice);
	}
}
