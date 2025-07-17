package com.charter.rewards.repository;

import com.charter.rewards.repository.model.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerAccount, Long> {
}
