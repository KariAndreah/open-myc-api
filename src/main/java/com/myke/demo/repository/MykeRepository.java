package com.myke.demo.repository;

import com.myke.demo.model.Cost;
import com.myke.demo.model.Myke;

import java.time.LocalTime;
import java.util.List;
// import java.sql.Time;
// import java.util.Date;
// import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MykeRepository extends JpaRepository<Myke, Long>{

    // Pagination and Sorting with Pagination
    @Query("SELECT m FROM Myke m")
    Page<Myke> getAllMics(Pageable pageable);

    //Find By ID
    @Query("SELECT m FROM Myke m WHERE m.id=?1")
    Optional<Myke> findById(Long id);

    // Find By Day with Pagination
    @Query("SELECT m FROM Myke m WHERE m.day LIKE %:day%")
    Page<Myke> findByDay(@Param("day") String day, Pageable pageable);

    // Find By Day and Free
    @Query(value = "SELECT m FROM Myke m WHERE (m.day is NULL OR m.day LIKE %:day%) AND (m.cost is NULL OR m.cost = :cost)")
    Page<Myke> findByDayFree(@Param("day") String day, @Param("cost") Cost id, Pageable pageable );

    // Find By Day and Time 
    @Query(value = "SELECT m FROM Myke m WHERE (m.day is NULL OR m.day LIKE %:day%) AND (m.start_time BETWEEN :timeA and :timeB)")
    Page<Myke> findByDayTime(@Param("day") String day, @Param("timeA") LocalTime start_timeA, @Param("timeB") LocalTime start_timeB, Pageable pageable );

     // Find By Day and Time and Free
    @Query(value = "SELECT m FROM Myke m WHERE (m.day is NULL OR m.day LIKE %:day%) AND (m.start_time BETWEEN :timeA and :timeB) AND (m.cost is NULL OR m.cost = :cost) ")
    Page<Myke> findByDayTimeFree(@Param("day") String day, @Param("timeA") LocalTime start_timeA, @Param("timeB") LocalTime start_timeB, @Param("cost") Cost id, Pageable pageable );

    // Find By Borough with Pagination
    @Query("SELECT m FROM Myke m WHERE m.borough LIKE %:borough%")
    Page<Myke> findByBorough(@Param("borough") String day, Pageable pageable);

     // Find By Borough and Free
    @Query(value = "SELECT m FROM Myke m WHERE (m.borough is NULL OR m.borough LIKE %:borough%) AND (m.cost is NULL OR m.cost = :cost)")
    Page<Myke> findByBoroughFree(@Param("borough") String borough, @Param("cost") Cost id, Pageable pageable );

     // Find By Borough and Day 
    @Query(value = "SELECT m FROM Myke m WHERE (m.borough is NULL OR m.borough LIKE %:borough%) AND (m.day is NULL OR m.day LIKE %:day%)")
    Page<Myke> findByBoroughDay(@Param("borough") String borough, @Param("day") String day, Pageable pageable );

    // Find By Borough and Day and Free 
    @Query(value = "SELECT m FROM Myke m WHERE (m.borough is NULL OR m.borough LIKE %:borough%) AND (m.day is NULL OR m.day LIKE %:day%) AND (m.cost is NULL OR m.cost = :cost)")
    Page<Myke> findByBoroughDayFree(@Param("borough") String borough, @Param("day") String day, @Param("cost") Cost id, Pageable pageable );

     // Find By Borough and Day and Time 
    @Query(value = "SELECT m FROM Myke m WHERE (m.borough is NULL OR m.borough LIKE %:borough%) AND (m.day is NULL OR m.day LIKE %:day%) AND (m.start_time BETWEEN :timeA and :timeB)")
    Page<Myke> findByBoroughDayTime(@Param("borough") String borough, @Param("day") String day, @Param("timeA") LocalTime start_timeA, @Param("timeB") LocalTime start_timeB, Pageable pageable );


    // Find By Borough and Day and Time and Free
    @Query(value = "SELECT m FROM Myke m WHERE (m.borough is NULL OR m.borough LIKE %:borough%) AND (m.day is NULL OR m.day LIKE %:day%) AND (m.start_time BETWEEN :timeA and :timeB) AND (m.cost is NULL OR m.cost = :cost) ")
    Page<Myke> findByBoroughDayTimeFree(@Param("borough") String borough, @Param("day") String day, @Param("timeA") LocalTime start_timeA, @Param("timeB") LocalTime start_timeB, @Param("cost") Cost id, Pageable pageable );

    // Find By Borough 
    @Query("SELECT m FROM Myke m WHERE m.borough LIKE %:borough%")
    List<Myke> findByBorough(@Param("borough") String borough);

    // Find By Boroughs 
    @Query("SELECT m FROM Myke m WHERE m.borough IN :borough")
    List<Myke> findByBoroughs(@Param("borough") List<String> borough);

  


    // @Query("SELECT m FROM Myke m WHERE m.day LIKE %:day%")
    // List<Myke> findByDay(@Param("day") String day);

    // Find By Day and ID?? Unnecessary 
    // @Query(value = "SELECT m FROM Myke m WHERE m.day LIKE %:day% AND m.id=:id", nativeQuery = true)
    // List<Myke> findByDayAndId(@Param("day") String day, @Param("id") long id);

    //  @Query(value = "SELECT m FROM Myke m WHERE m.day LIKE %:day% AND m.cost = :cost")
    // List<Myke> findByDayAndCost(@Param("day") String day, @Param("cost") Cost id );

    // @Query("SELECT m FROM Myke m WHERE m.cost LIKE %?1%")
    // List<Myke> findByCost(String cost);
    
    // @Query("SELECT m FROM Myke m WHERE m.time BETWEEN ?1 AND ?2")
    // List<Myke> findByTimeBetween(Time start,Time end);

    // Find All
    // @Query("SELECT m FROM Myke m")
    // List<Myke> findAll();
    
    
  
     // @Query("SELECT m FROM Myke m WHERE m.borough LIKE %?1%")
    // List<Myke> findByBorough(String borough);

    // @Query("SELECT m FROM Myke m WHERE m.name LIKE %?1%")
    // List<Myke> findByName(String name);
  


}
