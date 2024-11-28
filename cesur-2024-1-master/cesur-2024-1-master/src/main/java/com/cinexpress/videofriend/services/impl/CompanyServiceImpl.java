package com.cinexpress.videofriend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.repository.CompanyRepository;
import com.cinexpress.videofriend.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compañía con el ID: " + id + " no encontrada");
        }
    }

    @Override
    public Company updateCompany(Long id, Company companyDetails) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company existingCompany = optionalCompany.get();
            existingCompany.setName(companyDetails.getName());
            existingCompany.setAddress(companyDetails.getAddress());
            // Actualiza otros campos si los hay
            return companyRepository.save(existingCompany);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found with ID: " + id);
        }
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
