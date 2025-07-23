package com.charter.rewards.repository;

import com.charter.rewards.repository.model.CustomerTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Long> {
    @Query("""
        select ct from CustomerTransaction ct
            where ct.customer.customerId = :customerId
            order by ct.transactionDateTime
    """)
    List<CustomerTransaction> findAllByCustomerId(final @Param("customerId") Long customerId);
}
