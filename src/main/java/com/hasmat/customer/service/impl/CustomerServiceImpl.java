package com.hasmat.customer.service.impl;

import com.hasmat.customer.exception.ResourceAlreadyExistsException;
import com.hasmat.customer.exception.ResourceNotFoundException;
import com.hasmat.customer.model.Customer;
import com.hasmat.customer.repository.CustomerRepository;
import com.hasmat.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) throws ResourceAlreadyExistsException {
        if(customerRepository.findById(customer.getAutCustomerID()).isPresent()){
           throw new ResourceAlreadyExistsException();
        }else
        customer.setBitDelFlag(0);
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer doesn't exist with the given Id " +customerId));
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer, int customerId) {
        Customer updateCustomer1 = customerRepository.findById(customerId).get();
        updateCustomer1.setIndustryID(customer.getIndustryID());
        updateCustomer1.setVchCustomerName(customer.getVchCustomerName());
        updateCustomer1.setVchShortText(customer.getVchShortText());
        updateCustomer1.setVchAddress1(customer.getVchAddress1());
        updateCustomer1.setVchAddress2(customer.getVchAddress2());
        updateCustomer1.setVchStreet(customer.getVchStreet());
        updateCustomer1.setCountryID(customer.getCountryID());
        updateCustomer1.setVchZip(customer.getVchZip());
        updateCustomer1.setVchCity(customer.getVchCity());
        updateCustomer1.setVchPhone(customer.getVchPhone());
        updateCustomer1.setVchFax(customer.getVchFax());
        updateCustomer1.setVchWebsite(customer.getVchWebsite());
        updateCustomer1.setVchEmail(customer.getVchEmail());
        updateCustomer1.setVchComments(customer.getVchComments());
        customerRepository.save(updateCustomer1);
        return updateCustomer1;
    }
}
