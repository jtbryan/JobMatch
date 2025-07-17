package com.jobservice.dto;

public class JobResponseDTO {

    private String title;
    private String company;

    public JobResponseDTO() {}

    public JobResponseDTO(String title, String company) {
        this.title = title;
        this.company = company;
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
}
