package com.charter.rewards.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @Column(name = "transaction_id")
    @GeneratedValue
    private Long transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "customer_id"), insertable = false, updatable = false)
    private CustomerAccount customer;

    @Column(name = "transaction_date")
    private ZonedDateTime transactionDateTime;

    @Column(name = "post_date")
    private ZonedDateTime postDateTime;

    @Column(name = "transaction_amount", scale = 2, precision = 10)
    private BigDecimal amount;

    @Column(name = "note")
    private String note;
}
