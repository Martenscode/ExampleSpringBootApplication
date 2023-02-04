package com.application.example.service;

import com.application.example.domain.Example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@ActiveProfiles("unit")
@SpringBootTest
@Transactional
public class ExampleServiceTests {

    @Autowired
    private ExampleService service;

    @Test
    public void testFindAll() {
        Example example1 = new Example();
        example1.setName("testName1");
        example1.setEmail("testEmail1");
        service.save(example1);

        Example example2 = new Example();
        example2.setName("testName2");
        example2.setEmail("testEmail2");
        service.save(example2);

        List<Example> examples = service.findAll();
        assertNotNull(examples);
        assertEquals(examples.size(), 2);
    }

    @Test
    public void testSave() {
        Example example = new Example();
        example.setName("testName");
        example.setEmail("testEmail");
        boolean res = service.save(example);
        assertTrue(res);
        assertEquals(service.findAll().get(0).getName(), example.getName());
    }
}
