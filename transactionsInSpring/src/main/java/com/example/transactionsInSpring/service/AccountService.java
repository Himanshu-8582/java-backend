package com.example.transactionsInSpring.service;


import com.example.transactionsInSpring.entity.Account;
import com.example.transactionsInSpring.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account){
        accountRepository.save(account);
    }
}
