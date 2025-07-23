package com.charter.rewards.types;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class CustomerRewardsDto {
    private Long customerId;
    private ZonedDateTime beginDateTime;
    private ZonedDateTime endDateTime;
    private Integer points;
}
