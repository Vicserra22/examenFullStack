package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Company;

public interface CompanyService {
    Company createCompany(Company company);
    void deleteCompany(Long id);
    //Métodos añadidos para completar el CRUD
    Company updateCompany(Long id, Company company);
    List<Company> getAllCompanies();
}
