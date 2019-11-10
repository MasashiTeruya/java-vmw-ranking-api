package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserEntry;
import com.example.demo.repository.UserEntryRepository;

@Service
public class UserEntryService {
	@Autowired
	UserEntryRepository repository;

	public List<UserEntry> findAll() {
		return repository.findAll();
	}

	public List<UserEntry> findTop5ByOrderByScoreDesc() {
		return repository.findTop5ByOrderByScoreDesc();
	}

	public UserEntry save(UserEntry userEntry) {
		var result = repository.save(userEntry);
		return result;
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
