package com.charter.rewards.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRewardsSummary {
    private Long customerId;
    @JsonProperty("customerRewards")
    private List<CustomerRewardsDto> customerRewardDtos;
    @JsonProperty("rewardsTotal")
    private Integer totalRewardsAmount;
}
