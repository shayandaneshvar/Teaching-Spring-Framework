package com.shayandaneshvar.cucumberdemo.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public Integer adder(Integer a, Integer b) {
        return a + b;
    }
}
