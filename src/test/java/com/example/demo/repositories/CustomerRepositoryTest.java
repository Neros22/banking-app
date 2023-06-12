package com.example.demo.repositories;

import com.example.demo.models.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class CustomerRepositoryTest {

    @Mock
    CustomerRepository repository;

    @Test
    void findItemByName() {
        repository.save(new Customer("soren"));
        assertNotNull(repository.findItemByName("soren"));
    }
}