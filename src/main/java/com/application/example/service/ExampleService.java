package com.application.example.service;

import com.application.example.domain.Example;

import java.util.List;

public interface ExampleService {

    List<Example> findAll();

    boolean save(Example example);
}
