package com.travelserviceapi.travelserviceapi.adviser;

import com.devstack.pos.exception.EntryNotFoundException;
import com.devstack.pos.util.StandardResponse;
import com.travelserviceapi.travelserviceapi.exception.EntryNotFoundException;
import com.travelserviceapi.travelserviceapi.util.StandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWiderExceptionHandler {

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandResponse> handleEntryNotFoundException(EntryNotFoundException e){
        return new ResponseEntity<>(
                new StandResponse(404,e.getMessage(),e), HttpStatus.NOT_FOUND
        );

    }
}
