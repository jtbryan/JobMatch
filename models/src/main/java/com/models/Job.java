package com.models;

import jakarta.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;
    private String lowBand;
    private String highBand;
    private String location;
    private String createdAt;
    private String lastModified;

    public Job() {}

    public Job(String title, String company, String lowBand, String highBand, String location, String createdAt, String lastModified) {
        this.title = title;
        this.company = company;
        this.lowBand = lowBand;
        this.highBand = highBand;
        this.location = location;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHighBand() {
        return highBand;
    }

    public void setHighBand(String highBand) {
        this.highBand = highBand;
    }

    public String getLowBand() {
        return lowBand;
    }

    public void setLowBand(String lowBand) {
        this.lowBand = lowBand;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }
}
