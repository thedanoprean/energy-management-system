package com.example.energymanagement.controllers.handlers.exceptionsmodel;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;

public class DuplicateResourceException extends CustomException {
    private static final String MESSAGE = "Resource duplicated!";
    private static final HttpStatus httpStatus = HttpStatus.CONFLICT;

    public DuplicateResourceException(String resource) {
        super(MESSAGE,httpStatus, resource, new ArrayList<>());
    }

}