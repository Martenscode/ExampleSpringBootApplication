package com.application.example.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Table(name = "examples")
@EntityListeners(AuditingEntityListener.class)
public class Example {

    private String name;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Example{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
