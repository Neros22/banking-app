package com.example.demo.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.BankAccount;
import com.example.demo.services.BankAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/bankAccount")
@RestController
@CrossOrigin(origins = "*")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping(path = "/list")
    public List<BankAccount> getBankAccounts() {
        return bankAccountService.getBankAccounts();
    }

    @GetMapping(path = "/find/{id}")
    public Optional<BankAccount> getBankAccount(@PathVariable("id") Long id) {
        return bankAccountService.getBankAccount(id);
    }

    @PostMapping(path = "/create/{customerId}")
    public String addBankAccount(@PathVariable Long customerId,@RequestBody(required = false) BigDecimal initialBalance) {
        return bankAccountService.addNewBankAccount(customerId,initialBalance);
    }

    @PostMapping(path = "/transfer")
    public String transferMoney(@RequestParam Long accountId, @RequestBody BigDecimal amount, @RequestParam Long toAccountId) {
        return bankAccountService.pay(accountId,toAccountId,amount);
    }
}
