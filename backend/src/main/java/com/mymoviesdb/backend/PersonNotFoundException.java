package com.mymoviesdb.backend;

public class PersonNotFoundException extends RuntimeException {
    PersonNotFoundException(Long id) {
        super("Could not find person " + id);
    }
}
