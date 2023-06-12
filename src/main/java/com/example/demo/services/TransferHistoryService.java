package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.TransferHistory;
import com.example.demo.repositories.TransferHistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferHistoryService implements ITransferHistoryService{

    private final TransferHistoryRepository repository;
    private final SequenceGeneratorService sequenceGeneratorService;

    public SequenceGeneratorService getSequenceGeneratorService() {
        return sequenceGeneratorService;
    }

    public TransferHistoryRepository getRepository() {
        return repository;
    }

    @Autowired
    public TransferHistoryService(TransferHistoryRepository repository,SequenceGeneratorService sequenceGenerator) {
        this.repository = repository;
        this.sequenceGeneratorService = sequenceGenerator;
    }

    @Override
    public List<TransferHistory> listTransferHistoriesByAccountId(Long accountId) {
        return repository.listAllHistoryForAccountWithAccountId(accountId);
    }

    @Override
    public Optional<TransferHistory> getTransferHistory(Long id) {
        return repository.findById(id);
    }

    @Override
    public void createTransferHistory(TransferHistory transferHistory) {
        transferHistory.setId(sequenceGeneratorService.generateSequence(TransferHistory.SEQUENCE_NAME));
        repository.save(transferHistory);
    }

}
