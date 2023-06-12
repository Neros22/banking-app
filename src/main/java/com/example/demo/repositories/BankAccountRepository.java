package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.BankAccount;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends MongoRepository<BankAccount, Long> {

    @Query("{name:'?0'}")
    BankAccount findItemByName(String name);
    
    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<BankAccount> findAll(String category);
    
    long count();
}
