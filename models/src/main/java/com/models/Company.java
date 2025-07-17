package com.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String ceo;
    private String age;
    private String numEmployees;

    public Company() {
    }

    public Company(long id, String numEmployees, String age, String ceo, String name) {
        this.id = id;
        this.numEmployees = numEmployees;
        this.age = age;
        this.ceo = ceo;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(String numEmployees) {
        this.numEmployees = numEmployees;
    }
}
