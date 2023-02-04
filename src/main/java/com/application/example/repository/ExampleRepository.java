package com.application.example.repository;

import com.application.example.domain.Example;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExampleRepository {
    @Select("SELECT * FROM examples")
    List<Example> findAll();

    @Insert("INSERT INTO examples (name, email) VALUES (#{name}, #{email})")
    boolean save(Example example);

    default void preSave(Example example) {
        //custom prePersist
    }
}
