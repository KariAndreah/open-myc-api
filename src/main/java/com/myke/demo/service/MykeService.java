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

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MykeService {
    @Autowired
    private MykeRepository mykeRepository;

    // Get all mics
    public Page<Myke> getAllMics(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Myke> pagedResult = mykeRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult;
        } else {
            throw new MykeNotFoundException();
        }

    }

    // Get All Mics by Id
    public Optional<Myke> findById(long id) {
        return mykeRepository.findById(id);
    }

    // Get all Mics with Day and Pageable
    public List<Myke> findByDay(String day, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Myke> pagedResult = mykeRepository.findByDay(day, paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Myke>();
        }
    }

    // Get all Mics with Day and Free Pageable
    public List<Myke> findByDayFree(String day, Cost cost, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Myke> pagedResult = mykeRepository.findByDayFree(day, cost, paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Myke>();
        }
    }

    // Get all Mics with Day and Time Pageable
    public List<Myke> findByDayTime(String day, LocalTime start_timeA, LocalTime start_timeB, Integer pageNo,
            Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Myke> pagedResult = mykeRepository.findByDayTime(day, start_timeA, start_timeB, paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Myke>();
        }
    }

    // Get all Mics with Borough and Day and Time Pageable
    public List<Myke> findByBoroughDayTime(String borough, String day, LocalTime start_timeA, LocalTime start_timeB,
            Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Myke> pagedResult = mykeRepository.findByBoroughDayTime(borough, day, start_timeA, start_timeB, paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Myke>();
        }
    }

    // Get all Mics with Borough and Day and Time and Free Pageable
    public List<Myke> findByBoroughDayTimeFree(String borough, String day, LocalTime start_timeA, LocalTime start_timeB,
            Cost cost, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Myke> pagedResult = mykeRepository.findByBoroughDayTimeFree(borough, day, start_timeA, start_timeB, cost,
                paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Myke>();
        }
    }

    // Get all Mics with Borough
    public List<Myke> findByBorough(String borough) {
        String message = "---------- hi kari -------------- ";
        System.out.println(message + borough);

        return mykeRepository.findByBorough(borough);
    }

    // Get all Mics with Boroughs
    public List<Myke> findByBoroughs(List<String> borough) {
        String message = "---------- hi kari -------------- this is passing:  ";
        System.out.println(message + (borough));

        List<Myke> boroughList = mykeRepository.findByBoroughs(borough);
        // boroughList.addAll((mykeRepository.findByBoroughs(borough)).size());
        // System.out.println("------this is the list --------" + (boroughList.size()));
        return boroughList;
        // return boroughList;
        // return null;
    }

    // Get all Mics with Boroughs
    // public List<Myke> findByBoroughsDay(List<String> borough, String day, Integer
    // pageNo, Integer pageSize, String sortBy ) {
    // String message = "---------- hi kari -------------- this is passing: ";
    // System.out.println(message + (borough));

    // Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

    // Page<Myke> boroughList = mykeRepository.findByBoroughsDay(borough , day,
    // paging);

    // if(boroughList.hasContent()){
    // return boroughList.getContent();
    // } else {
    // return new ArrayList<Myke>();
    // }

    // // List<Myke> boroughList = mykeRepository.findByBoroughsDay(borough , day);
    // // boroughList.addAll((mykeRepository.findByBoroughs(borough)).size());
    // // System.out.println("------this is the list --------" +
    // (boroughList.size()));
    // // return boroughList;
    // // return boroughList;
    // // return null;
    // }

    public Page<Myke> findByBoroughsDay(List<String> borough, String day, Integer pageNo, Integer pageSize,
            String sortBy) {
        String message = "---------- hi kari -------------- this is passing:  ";
        System.out.println(message + (borough));

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Myke> boroughList = mykeRepository.findByBoroughsDay(borough, day, paging);

        if (boroughList.hasContent()) {
            return boroughList;
        } else {
            throw new MykeNotFoundException();
        }

        // List<Myke> boroughList = mykeRepository.findByBoroughsDay(borough , day);
        // boroughList.addAll((mykeRepository.findByBoroughs(borough)).size());
        // System.out.println("------this is the list --------" + (boroughList.size()));
        // return boroughList;
        // return boroughList;
        // return null;
    }

    public Page<Myke> findByBoroughsDayFree(List<String> borough, String day, Cost cost, Integer pageNo,
            Integer pageSize, String sortBy) {
        String message = "---------- hi kari -------------- this is passing:  ";
        System.out.println(message + (borough));

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Myke> boroughList = mykeRepository.findByBoroughsDayFree(borough, day, cost, paging);

        if (boroughList.hasContent()) {
            return boroughList;
        } else {
            throw new MykeNotFoundException();
        }

    }

    // Get All Mics by Day
    // public List<Myke> findByDay(String day) {
    // return mykeRepository.findByDay(day);
    // }

    // Get All Mics by Day and ID
    // public List<Myke> findByDayAndId(String day, Long id) {
    // return mykeRepository.findByDayAndId(day, id);
    // }

    // Get All Mics by Day and Cost
    // public List<Myke> findByDayAndCost(String day, Cost cost ) {
    // return mykeRepository.findByDayAndCost(day, cost);
    // }

    // Get All Mics by Day and Cost
    // public List<Myke> findByDayAndCostOptional(String day, Cost cost ) {
    // return mykeRepository.findByDayAndCostOptional(day, cost);
    // }

    // Get mic by ID
    // public Optional<Myke> getMykeById(Long id) {
    // return mykeRepository.findById(id);
    // }

    // Test
    // public List<Myke> findByDayLike(String day) {
    // return mykeRepository.findByDayLike(day);
    // }
    // Find by Day
    // public List<Myke> findByDay(String day) {

    // return mykeRepository.findByDay(day);
    // }

    // Get All
    // public List<Myke> findAll() {
    // return mykeRepository.findAll();
    // }

}
