package com.myke.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myke.demo.model.Cost;
import com.myke.demo.model.Myke;
import com.myke.demo.repository.MykeRepository;

import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MykeService {
    @Autowired
    private MykeRepository mykeRepository;

     // Get All
    public List<Myke> findAll() {
        return mykeRepository.findAll();
    }

     // Get All Mics by Id 
    public Optional<Myke> findById(long id) {
        return mykeRepository.findById(id);
    }

    //  Get All Mics by Day
    public List<Myke> findByDay(String day) {
        return mykeRepository.findByDay(day);
    }

    //Get All Mics by Day and ID
     public List<Myke> findByDayAndId(String day, Long id) {
        return mykeRepository.findByDayAndId(day, id);
    }

     //Get All Mics by Day and Cost
    //  public List<Myke> findByDayAndCost(String day, Cost cost ) {
    //     return mykeRepository.findByDayAndCost(day, cost);
    // }

     //Get All Mics by Day and Cost
    //  public List<Myke> findByDayAndCostOptional(String day, Cost cost ) {
    //     return mykeRepository.findByDayAndCostOptional(day, cost);
    // }

    // Get all Mics with Day and Cost Pageable
     public List<Myke> findByDayAndCostOptional(String day, Cost cost, Integer pageNo, Integer pageSize, String sortBy ) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy)); 

          Page<Myke> pagedResult = mykeRepository.findByDayAndCostOptional(day, cost, paging);

        if(pagedResult.hasContent()){
            return pagedResult.getContent();
        } else {
            return new ArrayList<Myke>(); 
        }
    }

    // Get all mics 
    public List<Myke> getAllMics(Integer pageNo, Integer pageSize, String sortBy) {
       
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy)); 
        Page<Myke> pagedResult = mykeRepository.findAll(paging);

        if(pagedResult.hasContent()){
            return pagedResult.getContent();
        } else {
            return new ArrayList<Myke>(); 
        }
    }

    // Get mic by ID
    // public Optional<Myke> getMykeById(Long id) {
    //     return mykeRepository.findById(id);
    // }

   


    //Test
    // public List<Myke> findByDayLike(String day) {
    //     return mykeRepository.findByDayLike(day);
    // }
    // Find by Day
    // public List<Myke> findByDay(String day) {

    //     return mykeRepository.findByDay(day);
    // }

}

