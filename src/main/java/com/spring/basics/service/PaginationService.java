package com.spring.basics.service;

import com.spring.basics.model.Pagination;
import com.spring.basics.repository.PaginationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaginationService
{
    @Autowired
    PaginationRepository repository;

    public List<Pagination> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Pagination> pagedResult = repository.findAll(paging);
        if(pagedResult.hasContent())
        {
            return pagedResult.getContent();
        }
        else
        {
            return new ArrayList<Pagination>();
        }
    }

    public Pagination create(Pagination pagination)
    {
        return repository.save(pagination);
    }
}
