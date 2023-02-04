package com.application.example.controller;

import com.application.example.domain.Example;
import com.application.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examples")
public class ExampleController {
    @Autowired
    private ExampleService exampleService;

    @GetMapping
    public List<Example> findAll() {
        return exampleService.findAll();
    }

    @PostMapping
    public boolean saveExample(@RequestBody Example example) {
        return exampleService.save(example);
    }
}
