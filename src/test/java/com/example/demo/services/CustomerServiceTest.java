package com.example.demo.services;

import com.example.demo.models.Customer;

import com.example.demo.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    SequenceGeneratorService sequenceGeneratorService;

    @Mock
    CustomerRepository repository;

    @Test
    void listCustomers() {
    }

    @Test
    void getCustomer() {
    }

    @Test
    void addNewCustomer() {
        Customer customer = new Customer("soren");
        customerService.addNewCustomer(customer);
        assertNotNull(customer.getCreated());
    }

    @Test
    void addAccountToCustomer() {
    }

    @Test
    void updateCustomer() {
    }

}