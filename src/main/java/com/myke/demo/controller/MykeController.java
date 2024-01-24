package com.myke.demo.controller;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import com.myke.demo.model.Cost;
import com.myke.demo.model.Myke;
import com.myke.demo.service.MykeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mics")
public class MykeController {
    @Autowired
    private MykeService mykeService;

    // Get all mics with pagination
    @GetMapping
    public ResponseEntity<Page<Myke>> getAllMics(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        Page<Myke> list = mykeService.getAllMics(pageNo, pageSize, sortBy);

        return new ResponseEntity<Page<Myke>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    // Get mic by ID
    @GetMapping("/{id}")
    public ResponseEntity<Page> findById(
            @PathVariable("id") long id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        Page<Myke> list = mykeService.findById(id, pageNo, pageSize, sortBy);

        // Map<String, Object> response = new HashMap<>();

        // response.put("mics", list);
        // response.put("totalMics", list.getTotalElements());

        return new ResponseEntity<Page>(list, new HttpHeaders(), HttpStatus.OK);

        // String message = "hi kari ";
        // System.out.println(borough);
    }

    // Get Mic by Day
    @GetMapping(value = "findByDay")
    public ResponseEntity<List<Myke>> findByDay(
            @RequestParam(value = "day", required = false, defaultValue = "") String day,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Myke> list = mykeService.findByDay(day, pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Myke>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    // Get mic by day and cost and paging
    @GetMapping(value = "findByDayFree")
    public ResponseEntity<List<Myke>> findByDayFree(
            @RequestParam(value = "day", required = false, defaultValue = "") String day,
            @RequestParam(value = "cost", required = false, defaultValue = "1") Cost cost,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Myke> list = mykeService.findByDayFree(day, cost, pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Myke>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    // Get mic by day and and time
    @GetMapping(value = "findByDayTime")
    public ResponseEntity<List<Myke>> findByDayTime(
            @RequestParam(value = "day", required = false, defaultValue = "") String day,
            @RequestParam(value = "startTime", required = false, defaultValue = "00:00:00") LocalTime start_timeA,
            @RequestParam(value = "endTime", required = false, defaultValue = "23:59:59") LocalTime start_timeB,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Myke> list = mykeService.findByDayTime(day, start_timeA, start_timeB, pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Myke>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    // Get mic by day and and time and free and paging
    @GetMapping(value = "findByAll")
    public ResponseEntity<List<Myke>> findByBoroughDayTime(
            @RequestParam(value = "day", required = false, defaultValue = "") String day,
            @RequestParam(value = "borough", required = false, defaultValue = "") String borough,
            @RequestParam(value = "startTime", required = false, defaultValue = "00:00:00") LocalTime start_timeA,
            @RequestParam(value = "endTime", required = false, defaultValue = "23:59:59") LocalTime start_timeB,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Myke> list = mykeService.findByBoroughDayTime(borough, day, start_timeA, start_timeB, pageNo, pageSize,
                sortBy);

        return new ResponseEntity<List<Myke>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    // Get mic by day and and time and free and paging
    @GetMapping(value = "findByAllFree")
    public ResponseEntity<List<Myke>> findByBoroughDayTimeFree(
            @RequestParam(value = "day", required = false, defaultValue = "") String day,
            @RequestParam(value = "borough", required = false, defaultValue = "") String borough,
            @RequestParam(value = "startTime", required = false, defaultValue = "00:00:00") LocalTime start_timeA,
            @RequestParam(value = "endTime", required = false, defaultValue = "23:59:59") LocalTime start_timeB,
            @RequestParam(value = "cost", required = false, defaultValue = "1") Cost cost,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Myke> list = mykeService.findByBoroughDayTimeFree(borough, day, start_timeA, start_timeB, cost, pageNo,
                pageSize, sortBy);

        return new ResponseEntity<List<Myke>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    // Get Mic by Borough
    @GetMapping(value = "findByBorough")
    // public void ResponseEntity()
    public ResponseEntity<List<Myke>> findByBorough(
            @RequestParam(value = "borough", required = false, defaultValue = "") String borough) {
        List<Myke> list = mykeService.findByBorough(borough);

        return new ResponseEntity<List<Myke>>(list, new HttpHeaders(), HttpStatus.OK);

        // String message = "hi kari ";
        // System.out.println(borough);
    }

    // Get Mic by Borough
    @GetMapping(value = "findByBoroughs")
    // public void ResponseEntity()
    public ResponseEntity<List<Myke>> findByBoroughs(
            @RequestParam(value = "borough", required = false, defaultValue = "") List<String> borough) {
        List<Myke> list = mykeService.findByBoroughs(borough);

        return new ResponseEntity<List<Myke>>(list, new HttpHeaders(), HttpStatus.OK);

        // String message = "hi kari ";
        // System.out.println(borough);
    }

    // Get Mic by Borough and day
    @GetMapping(value = "findByBoroughsDay")
    // public void ResponseEntity()
    public ResponseEntity<Page> findByBoroughsDay(
            @RequestParam(value = "borough", required = false, defaultValue = "") List<String> borough,
            @RequestParam(value = "day", required = false, defaultValue = "") String day,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        Page<Myke> list = mykeService.findByBoroughsDay(borough, day, pageNo, pageSize, sortBy);

        // Map<String, Object> response = new HashMap<>();

        // response.put("mics", list);
        // response.put("totalMics", list.getTotalElements());

        return new ResponseEntity<Page>(list, new HttpHeaders(), HttpStatus.OK);

        // String message = "hi kari ";
        // System.out.println(borough);
    }

    // Get Mic by Borough and day
    @GetMapping(value = "findByBoroughsDayFree")
    // public void ResponseEntity()
    public ResponseEntity<Page> findByBoroughsDayFree(
            @RequestParam(value = "borough", required = false, defaultValue = "") List<String> borough,
            @RequestParam(value = "day", required = false, defaultValue = "") String day,
            @RequestParam(value = "cost", required = false, defaultValue = "") Cost cost,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        Page<Myke> list = mykeService.findByBoroughsDayFree(borough, day, cost, pageNo, pageSize, sortBy);

        // Map<String, Object> response = new HashMap<>();

        // response.put("mics", list);
        // response.put("totalMics", list.getTotalElements());

        return new ResponseEntity<Page>(list, new HttpHeaders(), HttpStatus.OK);

        // String message = "hi kari ";
        // System.out.println(borough);
    }

    // Get mic by Day
    // @GetMapping("/day={day}")
    // public List<Myke> findByDay(@PathVariable String day) {
    // return mykeService.findByDay(day);
    // }

    // Get mic by ID
    // @GetMapping("/id={id}&day={day}")
    // public List<Myke> findByDayAndId(@PathVariable String day, Long id) {
    // return mykeService.findByDayAndId(day, id);
    // }

    // Get mic by day and cost
    // @GetMapping(value = "test")
    // public List<Myke> findByDayAndCost( @RequestParam("day") String day,
    // @RequestParam("cost") Cost cost )
    // {
    // return mykeService.findByDayAndCost(day, cost );
    // }

    // Get mic by day and cost
    // @GetMapping(value = "findBy")
    // public List<Myke> findByDayAndCostOptional(
    // @RequestParam(value = "day", required=false, defaultValue = "") String day,
    // @RequestParam(value = "cost", required=false) Cost cost )
    // {
    // return mykeService.findByDayAndCostOptional(day, cost );
    // }

    // Get all parameters
    // @GetMapping(value = "test")
    // @ResponseBody
    // public String updateFoos(@RequestParam Map<String,String> allParams) {
    // return "Parameters are " + allParams.entrySet();
    // }

    // Get mic by ID
    // @GetMapping("/{id}")
    // public Optional<Myke> getMicById(@PathVariable Long id) {
    // return mykeService.getMykeById(id);
    // }

    // Get mic by day
    // @GetMapping(value = "mics/{day}")
    // public List<Myke> findAllByDay(String day) {
    // return mykeService.findAllByDay(day);
    // }

    // Geta all mics
    // @GetMapping("/{day}")
    // public ResponseEntity<List<Myke>> findAllBy()

    // Get mic by ID
    // @GetMapping("/{day}")
    // public List<Myke> findByDayLike(@PathVariable String day) {
    // return mykeService.findByDayLike(day);
    // }
    // @GetMapping("/{day}")
    // public List<Myke> findByDay(@PathVariable String day) {
    // return mykeService.findByDay(day);
    // }

    // Get all mics
    // @GetMapping
    // public List<Myke> findAll() {
    // return mykeService.findAll();
    // }

}
