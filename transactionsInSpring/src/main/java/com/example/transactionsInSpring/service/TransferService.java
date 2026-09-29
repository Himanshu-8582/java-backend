package com.example.transactionsInSpring.service;

import com.example.transactionsInSpring.entity.Account;
import com.example.transactionsInSpring.entity.TransferRecord;
import com.example.transactionsInSpring.repository.AccountRepository;
import com.example.transactionsInSpring.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service

public class TransferService {

    private AccountRepository accountRepository;
    private TransferRepository transferRepository;

    public TransferService(AccountRepository accountRepository, TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Transactional
    public void transfer(Long fromAccountId,
                         Long toAccountId,
                         BigDecimal amount) throws Throwable {

        Account fromAccount =
                accountRepository.findById(fromAccountId)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        Account toAccount =
                accountRepository.findById(toAccountId)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        fromAccount.debitAccount(amount);
//        accountRepository.saveAndFlush(fromAccount);

        toAccount.creditAccount(amount);
//        accountRepository.saveAndFlush(toAccount);

        transferRepository.save(new TransferRecord(
                fromAccountId,
                toAccountId,
                amount,
                LocalDate.now()
        ));
//        transferRepository.flush();

//        throw new RuntimeException("Some Error Occured");
    }
}
