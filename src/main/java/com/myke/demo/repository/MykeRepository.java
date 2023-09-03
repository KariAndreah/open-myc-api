package com.myke.demo.repository;

import com.myke.demo.model.Cost;
import com.myke.demo.model.Myke;

// import java.sql.Time;
// import java.util.Date;
import java.util.List;
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

    @Query("SELECT m FROM Myke m")
    List<Myke> findAll();
    
    @Query("SELECT m FROM Myke m WHERE m.id=?1")
    Optional<Myke> findById(Long id);
  
    // @Query("SELECT m FROM Myke m WHERE m.borough LIKE %?1%")
    // List<Myke> findByBorough(String borough);

    // @Query("SELECT m FROM Myke m WHERE m.name LIKE %?1%")
    // List<Myke> findByName(String name);

    @Query("SELECT m FROM Myke m WHERE m.day LIKE %:day%")
    List<Myke> findByDay(@Param("day") String day);

    @Query(value = "SELECT m FROM Myke m WHERE m.day LIKE %:day% AND m.id=:id", nativeQuery = true)
    List<Myke> findByDayAndId(@Param("day") String day, @Param("id") long id);

    //  @Query(value = "SELECT m FROM Myke m WHERE m.day LIKE %:day% AND m.cost = :cost")
    // List<Myke> findByDayAndCost(@Param("day") String day, @Param("cost") Cost id );

    @Query(value = "SELECT m FROM Myke m WHERE (m.day is NULL OR m.day LIKE %:day%) AND (m.cost is NULL OR m.cost = :cost)")
    Page<Myke> findByDayAndCostOptional(@Param("day") String day, @Param("cost") Cost id, Pageable pageable );


    // @Query("SELECT m FROM Myke m WHERE m.cost LIKE %?1%")
    // List<Myke> findByCost(String cost);
    
    // @Query("SELECT m FROM Myke m WHERE m.time BETWEEN ?1 AND ?2")
    // List<Myke> findByTimeBetween(Time start,Time end);
  
  
  
    // Pagination and Sorting with Pageable
    @Query("SELECT m FROM Myke m")
    Page<Myke> getAllMics(Pageable pageable);

}
