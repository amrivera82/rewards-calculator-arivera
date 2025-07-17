package com.charter.rewards.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "customer_transaction")
public class CustomerTransaction {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long transactionId;

    @Column(name = "customer_id")
    private Long customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerAccount customer;

    @Column(name = "transaction_date")
    private ZonedDateTime transactionDate;

    @Column(name = "post_date")
    private ZonedDateTime postDateTime;

    @Column(name = "transaction_amount")
    private BigDecimal amount;

    @Column(name = "note")
    private String note;
}
