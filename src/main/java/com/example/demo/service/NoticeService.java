package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.NoticeDTO;
import com.example.demo.dto.UpdateNoticeRequest;
import com.example.demo.entity.Notice;
import com.example.demo.repository.NoticeRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeService {
	
	private final NoticeRepository noticeRepository;
	
	//공지사항 글 추가 메서드
	public Notice save(NoticeDTO dto) {
		return noticeRepository.save(dto.toEntity());
	}
	
	public List<Notice> findAll() {
		return noticeRepository.findAll();
	}
	
	//no를통해 하나 조회하는 메서드
	public Notice findById(Long no) {
		return noticeRepository.findById(no)
				.orElseThrow(() -> new IllegalArgumentException("not found:" + no));
	}
	
	//공지사항 삭제하는 메서드
	public void delete(long no) {
		noticeRepository.deleteById(no);
	}
	
	//공지사항 수정
	@Transactional
	public Notice update(long no, UpdateNoticeRequest request) {
		Notice notice = noticeRepository.findById(no)
				.orElseThrow(() -> new IllegalArgumentException("not found:" + no));
		
		notice.update(request.getTitle(), request.getContent());
		return notice;
	}
}
