package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.BankAccount;
import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository repository;
    private final SequenceGeneratorService sequenceGeneratorService;

    public SequenceGeneratorService getSequenceGeneratorService() {
        return sequenceGeneratorService;
    }

    public CustomerRepository getRepository() {
        return repository;
    }

    @Autowired
    public CustomerService(CustomerRepository repository,SequenceGeneratorService sequenceGenerator) {
        this.repository = repository;
        this.sequenceGeneratorService = sequenceGenerator;
    }

    @Override
    public List<Customer> listCustomers() {
        return getRepository().findAll();
    }

    @Override
    public Optional<Customer> getCustomer(Long id) {
        return getRepository().findById(id);
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        customer.setId(getSequenceGeneratorService().generateSequence(Customer.SEQUENCE_NAME));
        customer.setCreated(new Date());
        customer.setStatusActive(true);
        return repository.save(customer);
    }

    @Override
    public void addAccountToCustomer(Customer customer,BankAccount account){
        customer.getAccounts().add(account);
        updateCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        customer.setUpdated(new Date());
        repository.save(customer);
    }

}
