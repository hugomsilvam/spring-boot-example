package com.workshop.exampleapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class ProductNotFoundException extends HttpClientErrorException {

    public ProductNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }
}
