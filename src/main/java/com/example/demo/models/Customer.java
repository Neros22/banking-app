package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document("Customer")
@Data
@EqualsAndHashCode(callSuper = false)
public class Customer extends BaseModel {

    @Transient
    public static final String SEQUENCE_NAME = "customers_sequence";

    private String name;
    
    @JsonManagedReference
    @DocumentReference(lazy = true)
    private List<BankAccount> accounts;

    public Customer(String name){
        this.name = name;
    }
}