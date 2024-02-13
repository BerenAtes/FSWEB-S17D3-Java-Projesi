package com.workintech.S17D3.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ZooGlobalExceptionsHandler {
    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handleZooException(ZooException zooException){
    log.error("ZooException occured.Exception details: " + zooException.getMessage());
    ZooErrorResponse zooErrorResponse=new ZooErrorResponse(zooException.getHttpStatus().value(),zooException.getMessage(),System.currentTimeMillis());
    return new ResponseEntity<>(zooErrorResponse,zooException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handleUnknownAllException(Exception exception){
        log.error("Exception occured.Exception details: " + exception.getMessage());
        ZooErrorResponse zooErrorResponse=new ZooErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(zooErrorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}