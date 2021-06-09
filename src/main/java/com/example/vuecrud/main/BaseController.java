package com.example.vuecrud.main;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    protected ResponseEntity createResponseEntity(boolean isSuccess, Object body, HttpHeaders headers) {
        if (!isSuccess) {
            body = null;
            headers = null;
        }
        return ResponseEntity.status(isSuccess ? HttpStatus.OK : HttpStatus.BAD_REQUEST).headers(headers).body(body);
    }

    protected ResponseEntity createResponseEntity(boolean isSuccess, Object body) {
        return createResponseEntity(isSuccess, body, null);
    }

}
