package com.hasmat.customer.controller;

import com.hasmat.customer.model.Customer;
import com.hasmat.customer.repository.CustomerRepository;
import com.hasmat.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    //Add Customer
    @PostMapping(value = "/add")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
        Customer customer1 = customerService.addCustomer(customer);
        return  ResponseEntity.status(HttpStatus.CREATED).body(customer1);
    }

     //Welcome page
     @GetMapping(value = "/home")
     public String home(){
         return "Welcome to home.";
     }

    //Get All Customer
    @GetMapping(value = "/all")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> allCustomers = customerService.findAllCustomers();
        return  ResponseEntity.ok(allCustomers);
    }

    //Get Customer By Id
    @GetMapping(value = "/{customerId}")
    public  ResponseEntity<Customer> getCustomerById(@PathVariable int customerId){
        Customer customer = customerService.findCustomerById(customerId);
        return  ResponseEntity.ok(customer);
    }

    //Delete Customer
    @DeleteMapping(value = "/delete/{customerId}")
    public  ResponseEntity<Customer> deleteCustomerById(@PathVariable int customerId){
        Customer customer1 = customerService.findCustomerById(customerId);
        customer1.setBitDelFlag(1);
        customerRepository.save(customer1);
        return ResponseEntity.ok(customer1);
    }

    //Update Customer
    @PutMapping(value = "/update/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer, @PathVariable int customerId){
      Customer updateCustomer1 = customerService.updateCustomer(customer, customerId);
      return ResponseEntity.ok(updateCustomer1);
    }
}
