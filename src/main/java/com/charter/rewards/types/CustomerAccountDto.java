package com.charter.rewards.types;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class CustomerAccountDto {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String timeZoneId;
    private ZonedDateTime createdDate;
    private AccountStatus accountStatus;
}
