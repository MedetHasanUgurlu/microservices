package net.javaguides.employeeservice.exceptions;

import net.javaguides.employeeservice.constants.ErrorConstants;
import net.javaguides.employeeservice.exceptions.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        return new ResponseEntity(ErrorDetails.builder()
                .errorCode(ErrorConstants.RESOURCE_NOT_FOUND)
                .localDateTime(LocalDateTime.now())
                .message(exception.getMessage())
                .path(webRequest.getContextPath())
                .build(), HttpStatus.NOT_FOUND);
    }

}
