package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.TransferHistory;
import com.example.demo.services.TransferHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/transfer/history")
@RestController
@CrossOrigin(origins = "*")
public class TransferHistoryController {
    private final TransferHistoryService transferHistoryService;

    @Autowired
    public TransferHistoryController(TransferHistoryService transferHistoryService) {
        this.transferHistoryService = transferHistoryService;
    }

    @GetMapping(path = "/list/{accountId}")
    public List<TransferHistory> listTransferHistoryForAccount(@PathVariable("accountId") Long id) {
        return transferHistoryService.listTransferHistoriesByAccountId(id);
    }

    @GetMapping(path = "/find/{id}")
    public Optional<TransferHistory> getTransferHistoryById(@PathVariable("id") Long id) {
        return transferHistoryService.getTransferHistory(id);
    }
}