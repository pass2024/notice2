package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{

}
