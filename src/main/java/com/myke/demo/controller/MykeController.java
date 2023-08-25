package com.myke.demo.controller;

import java.util.List;
import java.util.Optional;

import com.myke.demo.model.Myke;
import com.myke.demo.service.MykeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mics")
public class MykeController {
    @Autowired
    private MykeService mykeService;

	// Geta all mics
	@GetMapping
	public List<Myke> getAllMics() {
		return mykeService.getAllMics();
	}

	 // Get mic by ID
    @GetMapping("/{id}")
    public Optional<Myke> getMicById(@PathVariable Long id) {
        return mykeService.getMykeById(id);
    }
    
}
