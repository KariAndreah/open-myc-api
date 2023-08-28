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

    // Get all mics 
    @GetMapping
    public List<Myke> findAll() {
        return mykeService.findAll();
    }

    // Get mic by ID
    @GetMapping("/id/{id}")
    public Optional<Myke> findById(@PathVariable Long id) {
        return mykeService.findById(id);
    }

    //   Get mic by Day
    @GetMapping(value ="/day/{day}")
    public List<Myke> findByDay(@PathVariable String day) {
        return mykeService.findByDay(day);
    }

    // Get mic by ID
    // @GetMapping("/{id}/{day}")
    // public List<Myke> findByDayAndId(@PathVariable String day, Long id) {
    //     return mykeService.findByDayAndId(day, id);
    // }

	// Geta all mics
	// @GetMapping
    // public ResponseEntity<List<Myke>> getAllMics(
    //                     @RequestParam(defaultValue = "0") Integer pageNo,
    //                     @RequestParam(defaultValue = "10") Integer pageSize,
    //                     @RequestParam(defaultValue = "id") String sortBy)
    // {
    //     List<Myke> list = mykeService.getAllMics(pageNo, pageSize, sortBy);

    //     return new ResponseEntity<List<Myke>>(list, new HttpHeaders(), HttpStatus.OK);
    // }

	 // Get mic by ID
    // @GetMapping("/{id}")
    // public Optional<Myke> getMicById(@PathVariable Long id) {
    //     return mykeService.getMykeById(id);
    // }

    //Get mic by day
    // @GetMapping(value = "mics/{day}")
    // public List<Myke> findAllByDay(String day) {
    //     return mykeService.findAllByDay(day);
    // }

    // Geta all mics
	// @GetMapping("/{day}")
    // public ResponseEntity<List<Myke>> findAllBy()

     // Get mic by ID
    // @GetMapping("/{day}")
    // public List<Myke> findByDayLike(@PathVariable String day) {
    //     return mykeService.findByDayLike(day);
    // }
    //  @GetMapping("/{day}")
    // public List<Myke> findByDay(@PathVariable String day) {
    //     return mykeService.findByDay(day);
    // }
   
}

