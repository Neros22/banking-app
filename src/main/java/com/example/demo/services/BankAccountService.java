package com.example.demo.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import java.util.Optional;
import com.example.demo.models.BankAccount;
import com.example.demo.models.Customer;
import com.example.demo.models.TransferHistory;
import com.example.demo.repositories.BankAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService implements IBankAccountService {

    private final BankAccountRepository repository;
    private final SequenceGeneratorService sequenceGeneratorService;
    private final CustomerService customerService;
    private final TransferHistoryService historyService;

    public TransferHistoryService getHistoryService() {
        return historyService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public SequenceGeneratorService getSequenceGeneratorService() {
        return sequenceGeneratorService;
    }

    public BankAccountRepository getRepository() {
        return repository;
    }

    @Autowired
    public BankAccountService(BankAccountRepository repository, SequenceGeneratorService sequenceGeneratorService,
            CustomerService customerService, TransferHistoryService historyService) {
        this.repository = repository;
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.customerService = customerService;
        this.historyService = historyService;
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return repository.findAll();
    }

    @Override
    public String addNewBankAccount(Long customerId, BigDecimal initialBalance) {
        Optional<Customer> customer = getCustomerService().getCustomer(customerId);
        if(customer.isPresent()){
            BankAccount newAccount = new BankAccount();
            newAccount.setStatusActive(true);
            newAccount.setCustomer(customer.get());
            newAccount.setId(sequenceGeneratorService.generateSequence(BankAccount.SEQUENCE_NAME));
            newAccount.setCreated(new Date());
            if(initialBalance!=null){
                newAccount.setBalance(initialBalance);
            }
            repository.save(newAccount);
            getCustomerService().addAccountToCustomer(customer.get(), newAccount);
            return "Bank Account No: " + newAccount.getId() + " created for Customer id: " +customerId +" with balance: " + newAccount.getBalance();
        } else {
            return "Customer not found!";
        } 
    }

    @Override
    public Optional<BankAccount> getBankAccount(Long id) {
        return repository.findById(id);
    }

    public Boolean deductAmountFromAccountBalance(BankAccount account, BigDecimal amount){
        if(account.getBalance().compareTo(amount)>=0){
            account.setBalance(account.getBalance().subtract(amount));
            account.setUpdated(new Date());
            repository.save(account);
            return true;
        } else {
            return false;
        }
    }

    public BigDecimal addAmountToAccountBalance(BankAccount account, BigDecimal amount){
        account.setBalance(account.getBalance().add(amount));
        account.setUpdated(new Date());
        repository.save(account);
        return account.getBalance();
    }

    @Override
    public String pay(Long accountId, Long toAccountId, BigDecimal amount) {
        Optional<BankAccount> fromAccount = repository.findById(accountId);
        Optional<BankAccount> toAccount = repository.findById(toAccountId);
        String result = null;
        if(fromAccount.isPresent() && toAccount.isPresent()){
            boolean deducted = deductAmountFromAccountBalance(fromAccount.get(),amount);
            if(deducted){
                addAmountToAccountBalance(toAccount.get(),amount);
                TransferHistory newTransfer = new TransferHistory();
                newTransfer.setFromAccountId(accountId);
                newTransfer.setToAccountId(toAccountId);
                newTransfer.setTransferBalance(amount);
                newTransfer.setCreated(new Date());
                historyService.createTransferHistory(newTransfer);
                result = "Success";
            } else {
                result = "Account balance with id " +accountId + " is insufficient";
            }
        } else {
            result = "One of the accounts is not found! check again! ";
        }
        return result;
    }

}
