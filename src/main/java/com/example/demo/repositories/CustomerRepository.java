package com.example.demo.repositories;

import com.example.demo.models.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {

    @Query("{name:'?0'}")
    Customer findItemByName(String name);
    
    long count();
}
