package com.charter.rewards.types;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class CustomerTransactionDto {
    private Long id;
    private BigDecimal amount;
    private String note;
    private ZonedDateTime transactionTime;
}
