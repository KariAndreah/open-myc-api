package com.myke.demo.controller;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.myke.demo.model.Cost;
import com.myke.demo.model.Myke;
import com.myke.demo.service.MykeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mics")
public class MykeController {
    @Autowired
    private MykeService mykeService;

    // Get all mics 
    // @GetMapping
    // public List<Myke> findAll() {
    //     return mykeService.findAll();
    // }

    // Get mic by ID
    @GetMapping("/{id}")
    public Optional<Myke> findById(@PathVariable (required = false) Long id) {
        return mykeService.findById(id);
    }

    //   Get mic by Day
    @GetMapping("/day={day}")
    public List<Myke> findByDay(@PathVariable String day) {
        return mykeService.findByDay(day);
    }

    // Get mic by ID
    @GetMapping("/id={id}&day={day}")
    public List<Myke> findByDayAndId(@PathVariable String day, Long id) {
        return mykeService.findByDayAndId(day, id);
    }

    // Get mic by day and cost 
    // @GetMapping(value = "test")
    // public List<Myke> findByDayAndCost( @RequestParam("day") String day,
    //                                     @RequestParam("cost") Cost cost ) 
    //                                  {
    //     return mykeService.findByDayAndCost(day, cost );
    // }

    // Get mic by day and cost 
    // @GetMapping(value = "findBy")
    // public List<Myke> findByDayAndCostOptional(
    //                          @RequestParam(value = "day", required=false, defaultValue = "") String day,
    //                         @RequestParam(value = "cost", required=false) Cost cost ) 
    //  {
    //     return mykeService.findByDayAndCostOptional(day, cost );
    // }
   
    // Get mic by day and cost and paging
    @GetMapping(value ="findBy")
    public ResponseEntity<List<Myke>> findByDayAndCostOptional(
                        @RequestParam(value = "day", required=false, defaultValue = "") String day,
                        @RequestParam(value = "cost", required=false) Cost cost,
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Myke> list = mykeService.findByDayAndCostOptional(day, cost, pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Myke>>(list, new HttpHeaders(), HttpStatus.OK);
    }

       // Get mic by day and cost and paging
    @GetMapping(value ="findByTime")
    public ResponseEntity<List<Myke>> findByDayAndTime(
                        @RequestParam(value = "day", required=false, defaultValue = "") String day,
                        @RequestParam(value = "startTime", required=false, defaultValue = "00:00:00") LocalTime start_timeA,
                        @RequestParam(value = "startTime", required=false, defaultValue = "23:59:59") LocalTime start_timeB,
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Myke> list = mykeService.findByDayAndTime(day, start_timeA, start_timeB, pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Myke>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    // Get all parameters
    @GetMapping(value = "test")
    @ResponseBody
    public String updateFoos(@RequestParam Map<String,String> allParams) {
        return "Parameters are " + allParams.entrySet();    
    }


	// Get all mics with pagination
	@GetMapping
    public ResponseEntity<List<Myke>> getAllMics(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Myke> list = mykeService.getAllMics(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Myke>>(list, new HttpHeaders(), HttpStatus.OK);
    }

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

