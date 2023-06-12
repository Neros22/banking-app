package com.example.demo.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.BankAccount;

public interface IBankAccountService {
    List<BankAccount> getBankAccounts();
    String addNewBankAccount(Long customerId, BigDecimal initialBalance);
    Optional<BankAccount> getBankAccount(Long id);
    String pay(Long accountId, Long toAccountId, BigDecimal amount);
}
