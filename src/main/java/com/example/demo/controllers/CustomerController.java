package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Customer;
import com.example.demo.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/customer")
@RestController
@CrossOrigin(origins = "*")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/list")
    public List<Customer> listCustomers() {
        return customerService.listCustomers();
    }

    @GetMapping(path = "/find/{id}")
    public Optional<Customer> getCustomer(@PathVariable("id") Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping(path = "/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.addNewCustomer(customer);
    }
}
