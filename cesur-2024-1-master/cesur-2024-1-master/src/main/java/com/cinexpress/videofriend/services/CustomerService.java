package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    void addClientToCompany(Long customerId, Long companyId);
    List<Movie> listAllCustomerMovies(Customer customer);
    boolean hasPremiumSubscription(Long customerId);
    void deactivatePremiumSubscription(Long customerId);
    //Métodos añadidos para completar el CRUD
    void deleteCustomer(Long id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Long id, Customer customer);
}
