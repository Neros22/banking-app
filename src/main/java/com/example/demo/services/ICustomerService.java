package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.BankAccount;
import com.example.demo.models.Customer;

public interface ICustomerService {

    List<Customer> listCustomers();
    Optional<Customer> getCustomer(Long id);
    Customer addNewCustomer(Customer customer);
    void addAccountToCustomer(Customer customer,BankAccount account);
}
