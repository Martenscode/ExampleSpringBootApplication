package com.application.example.service;

import com.application.example.domain.Example;
import com.application.example.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleRepository exampleRepository;


    @Override
    public List<Example> findAll() {
        return exampleRepository.findAll();
    }

    @Override
    public boolean save(Example example) {
        exampleRepository.preSave(example);
        exampleRepository.save(example);
        return true;
    }
}
