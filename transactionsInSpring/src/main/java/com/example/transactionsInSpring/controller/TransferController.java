package com.example.transactionsInSpring.controller;

import com.example.transactionsInSpring.entity.TransferRecord;
import com.example.transactionsInSpring.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String> transferAmount(
            @RequestBody TransferRecord record) throws Throwable {

        transferService.transfer(record.getFromAccountId(),
                record.getToAccountId(),
                record.getAmount());

        return ResponseEntity.ok("DONE");
    }
}
