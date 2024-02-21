package com.hasmat.customer.service;

import com.hasmat.customer.exception.ResourceAlreadyExistsException;
import com.hasmat.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer) throws ResourceAlreadyExistsException;

    List<Customer> findAllCustomers();

    Customer findCustomerById(int customerId);

    Customer updateCustomer(Customer customer, int customerId);
}
