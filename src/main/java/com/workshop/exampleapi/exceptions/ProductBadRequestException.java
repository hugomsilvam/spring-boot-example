package com.workshop.exampleapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class ProductBadRequestException extends HttpClientErrorException {

    public ProductBadRequestException() {
        super(HttpStatus.BAD_REQUEST);
    }
}
