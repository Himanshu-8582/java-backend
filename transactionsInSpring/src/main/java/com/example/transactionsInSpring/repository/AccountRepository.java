package com.example.transactionsInSpring.repository;

import com.example.transactionsInSpring.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
