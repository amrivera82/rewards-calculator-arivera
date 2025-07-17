package com.charter.rewards.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomerRewardsSummary {
    @JsonProperty("customerInfo")
    private CustomerAccountDto customerAccountDto;
    @JsonProperty("customerRewards")
    private List<CustomerRewardsDto> customerRewardDtos;
    @JsonProperty("rewardsTotal")
    private Integer customerRewardsTotal;
}
