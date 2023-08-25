package com.myke.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.myke.demo.model.Myke;
import com.myke.demo.repository.MykeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MykeService {
    @Autowired
    private MykeRepository mykeRepository;

    // Get all mics 
    public List<Myke> getAllMics() {
        return mykeRepository.findAll(); 
    }

    // Get mic by ID
    public Optional<Myke> getMykeById(Long id) {
        return mykeRepository.findById(id);
    }

}

