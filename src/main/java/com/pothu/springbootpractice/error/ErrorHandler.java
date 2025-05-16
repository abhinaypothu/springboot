package com.pothu.springbootpractice.error;

import com.pothu.springbootpractice.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> errorDepartmentNotFound(DepartmentNotFoundException departmentNotFoundException, WebRequest webRequest){
         return ResponseEntity.status(HttpStatus.NOT_FOUND)
                 .body(new ErrorMessage(departmentNotFoundException.getMessage(),HttpStatus.NOT_FOUND));
    }
}
