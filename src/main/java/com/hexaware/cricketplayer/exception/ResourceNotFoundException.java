package com.hexaware.cricketplayer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;


public class ResourceNotFoundException extends ResponseStatusException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String msg) {
        super(HttpStatus.NOT_FOUND, msg);
    }

}