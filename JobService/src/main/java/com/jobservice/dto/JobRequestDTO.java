package com.jobservice.dto;

import jakarta.validation.constraints.NotBlank;

public class JobRequestDTO {
    @NotBlank(message="Job title is required.")
    private String title;

    @NotBlank(message="Company name is required.")
    private String company;

    private String lowBand;
    private String highBand;
    private String location;

    public JobRequestDTO() {}

    public JobRequestDTO(String title, String company, String lowBand, String highBand, String location) {
        this.title = title;
        this.company = company;
        this.lowBand = lowBand;
        this.highBand = highBand;
        this.location = location;
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

    public String getLowBand() {
        return lowBand;
    }

    public void setLowBand(String lowBand) {
        this.lowBand = lowBand;
    }

    public String getHighBand() {
        return highBand;
    }

    public void setHighBand(String highBand) {
        this.highBand = highBand;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
