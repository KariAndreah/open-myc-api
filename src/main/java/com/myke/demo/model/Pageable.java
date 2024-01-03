package com.myke.demo.model;

import org.springframework.data.domain.Sort;

public interface Pageable {
  int getPageNumber();

  int getPageSize();

  long getOffset();

  long getTotalElements();

  int getTotalPages();

  Sort getSort();

  Pageable next();

  Pageable previousOrFirst();

  Pageable first();

  boolean hasPrevious();

}
