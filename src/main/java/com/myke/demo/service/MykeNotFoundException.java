package com.myke.demo.service;

public class MykeNotFoundException extends RuntimeException {
    public MykeNotFoundException() {
        super("Mics not found with parameters: ");
    }

}
