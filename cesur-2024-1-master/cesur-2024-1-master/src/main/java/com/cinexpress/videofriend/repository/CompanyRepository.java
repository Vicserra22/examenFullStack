package com.cinexpress.videofriend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {  
    Optional<Company> findByName(String name);
    List<Company> findByAddress(String address);

}
