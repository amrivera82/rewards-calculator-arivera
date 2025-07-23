package com.charter.rewards.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTransactionDto {
    private Long transactionId;
    private BigDecimal amount;
    private String note;
    private ZonedDateTime transactionDateTime;
    private ZonedDateTime postDateTime;
}
