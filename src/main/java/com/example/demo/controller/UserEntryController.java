package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.model.UserEntry;
import com.example.demo.service.UserEntryService;

@RestController
@RequestMapping("/api/user-entries")
public class UserEntryController {
	@Autowired
	UserEntryService service;

	@GetMapping
	public ResponseEntity<?> getUserEntries() {
		var items = service.findTop5ByScoreDesc();
		return items.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(items);
	}

	@PostMapping
	public ResponseEntity<?> postUserEntry(@RequestBody UserEntry userEntry,
			UriComponentsBuilder uriComponentsBuilder) {
		var result = service.save(userEntry);
		var location = uriComponentsBuilder.path("/api/user-entries").buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(location).body(result);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteUserEntry(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
