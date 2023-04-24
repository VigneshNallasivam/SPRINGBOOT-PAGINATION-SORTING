package com.spring.basics.controller;

import com.spring.basics.model.Pagination;
import com.spring.basics.service.PaginationService;
import com.spring.basics.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class PaginationController
{
    @Autowired
    PaginationService service;

    @PostMapping("/post")
    public ResponseEntity<Response> insert(@RequestBody Pagination pagination)
    {
        Pagination pagination1 = service.create(pagination);
        Response response = new Response("All Data is written",pagination1);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping("/gett")
    public ResponseEntity<List<Pagination>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Pagination> list = service.getAllEmployees(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<Pagination>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
