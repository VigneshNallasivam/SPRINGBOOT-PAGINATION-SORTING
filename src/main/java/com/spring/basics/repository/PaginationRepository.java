package com.spring.basics.repository;

import com.spring.basics.model.Pagination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginationRepository extends JpaRepository<Pagination,Long>
{

}
