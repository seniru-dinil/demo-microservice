package edu.icet.department.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GloabalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String,String> map=new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> map.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return ResponseEntity.badRequest().body(map);
    }


    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleDepartmentNotFoundException(DepartmentNotFoundException e){
        return ResponseEntity.badRequest().body(Map.of("message",e.getMessage()));
    }


}
