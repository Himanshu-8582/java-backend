package com.example.transactionsInSpring.repository;

import com.example.transactionsInSpring.entity.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferRecord,Long> {
}
