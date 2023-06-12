package com.example.demo.models;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document("BankAccount")
@Data
@EqualsAndHashCode(callSuper = false)
public class BankAccount extends BaseModel{

    @Transient
    public static final String SEQUENCE_NAME = "bankAccount_sequence";
    
    private BigDecimal balance;
    
    @JsonBackReference
    @DocumentReference(lazy = true)
    private Customer customer;

    public BankAccount(){
        this.balance = BigDecimal.ZERO;
    }
    
}
