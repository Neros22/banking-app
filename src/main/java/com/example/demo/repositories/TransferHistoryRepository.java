package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.TransferHistory;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferHistoryRepository extends MongoRepository<TransferHistory, Long>{

    @Query("{ 'fromAccountId' : ?0 }")
    List<TransferHistory> listAllHistoryForAccountWithAccountId(Long accountId);
    
}
