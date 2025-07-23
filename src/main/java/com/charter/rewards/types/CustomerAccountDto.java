package com.charter.rewards.types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccountDto {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String timeZoneId;
    private ZonedDateTime createdDate;
    private AccountStatus accountStatus;
}
