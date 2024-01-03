package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.QnaDTO;
import com.example.demo.dto.UpdateNoticeRequest;
import com.example.demo.entity.Notice;
import com.example.demo.entity.Qna;
import com.example.demo.repository.QnaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class QnaService {

	
	private final QnaRepository qnaRepository;

	//qna 글 추가 메서드
	public Qna save(QnaDTO dto) {
		return qnaRepository.save(dto.toEntity());
	}
	public List<Qna> findAll() {
		return qnaRepository.findAll();
	}
	
	//no를통해 하나 조회하는 메서드
	public Qna findById(Long no) {
		return qnaRepository.findById(no)
				.orElseThrow(() -> new IllegalArgumentException("not found:" + no));
	}
	
	//공지사항 삭제하는 메서드
	public void delete(long no) {
		qnaRepository.deleteById(no);
	}
	
	//공지사항 수정
	@Transactional
	public Qna update(long no, UpdateNoticeRequest request) {
		Qna qna = qnaRepository.findById(no)
				.orElseThrow(() -> new IllegalArgumentException("not found:" + no));
		
		qna.update(request.getTitle(), request.getContent());
		return qna;
	}
}
