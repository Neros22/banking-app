package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.TransferHistory;

public interface ITransferHistoryService {

    List<TransferHistory> listTransferHistoriesByAccountId(Long accountId);
    Optional<TransferHistory> getTransferHistory(Long id);
    void createTransferHistory(TransferHistory transferHistory);
}
