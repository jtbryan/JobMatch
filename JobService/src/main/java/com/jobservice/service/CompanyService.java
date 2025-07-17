package com.jobservice.service;

import com.models.Company;
import com.jobservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public void AddCompany(String companyName) {

        Optional<Company> companyOptional = companyRepository.findByName(companyName);

        if (companyOptional.isEmpty()) {
            Company newCompany = new Company();
            newCompany.setName(companyName);
            companyRepository.save(newCompany);
        }
    }

}
