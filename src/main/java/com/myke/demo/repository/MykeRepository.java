package com.myke.demo.repository;

import com.myke.demo.model.Myke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MykeRepository extends JpaRepository<Myke, Long>{

}
