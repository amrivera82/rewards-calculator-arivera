package com.charter.rewards.repository;

import com.charter.rewards.repository.model.CustomerTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Long> {
    List<CustomerTransaction> findAllBy(final @Param("customerId") Long customerId);
    List<CustomerTransaction> findAllByCustomerIdAndTransactionDateIsAfter(final @Param("customerId") Long customerId,
                                                                           final ZonedDateTime transactionDate);
}
