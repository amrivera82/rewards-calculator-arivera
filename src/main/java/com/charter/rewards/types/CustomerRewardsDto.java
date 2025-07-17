package com.charter.rewards.types;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class CustomerRewardsDto {
    private CustomerAccountDto customerAccountDto;
    private ZonedDateTime beginDateTime;
    private ZonedDateTime endDateTime;
    private Integer points;
}
