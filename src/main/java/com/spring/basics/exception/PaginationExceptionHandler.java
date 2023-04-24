package com.spring.basics.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.spring.basics.utility.Response;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class PaginationExceptionHandler
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleMethodArgumentNotvalidException(MethodArgumentNotValidException e)
    {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        List<String> errMsg = errors
                .stream()
                .map(ObjectError-> ObjectError.getDefaultMessage())
                .collect(Collectors.toList());
        Response responseDto = new Response("Occurence of Exception in Usage of REST",errMsg.toString());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(PaginationException.class)
    public ResponseEntity<Response> handleEmployeeException(PaginationException e)
    {
        Response responseDto = new Response("Occurence of Exception in Usage of REST",e.getMessage());
        return new ResponseEntity<>(responseDto,HttpStatus.BAD_GATEWAY);
    }
}
