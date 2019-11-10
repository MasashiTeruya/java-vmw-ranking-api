package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserEntry;

public interface UserEntryRepository extends JpaRepository<UserEntry, Integer> {
	List<UserEntry> findTop5ByOrderByScoreDesc();
}
