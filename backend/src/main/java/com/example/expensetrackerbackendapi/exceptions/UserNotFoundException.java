package com.example.expensetrackerbackendapi.exceptions;


 public class UserNotFoundException extends RuntimeException {

 public UserNotFoundException(String message) {
        super(message);
    }

}
