package com.application.example.controller;

import com.application.example.domain.Example;
import com.application.example.repository.ExampleRepository;
import com.application.example.service.ExampleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("unit")
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ExampleControllerTests {

    private static final String ENDPOINT = "/api/examples";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ExampleService service;

    @Autowired
    private ExampleRepository repository;

    @Test
    public void testExamplesGET() throws Exception {
        List<Example> examples = new ArrayList<>();
        Example example1 = new Example();
        example1.setName("testName1");
        example1.setEmail("testEmail1");
        repository.save(example1);

        Example example2 = new Example();
        example2.setName("testName2");
        example2.setEmail("testEmail2");
        repository.save(example2);

        examples.add(example1);
        examples.add(example2);

        ObjectMapper mapper = new ObjectMapper();
        String expectedJson = mapper.writeValueAsString(examples);

        mockMvc.perform(get(ENDPOINT))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }

    @Test
    public void testExamplesPOST() throws Exception {
        Example example = new Example();
        example.setName("testName");
        example.setEmail("testEmail");

        ObjectMapper mapper = new ObjectMapper();
        String requestBodyJson = mapper.writeValueAsString(example);

        mockMvc.perform(post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBodyJson))
                .andExpect(status().isOk());
    }
}
