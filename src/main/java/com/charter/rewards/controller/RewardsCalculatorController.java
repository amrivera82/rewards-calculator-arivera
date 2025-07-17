package com.charter.rewards.controller;

import com.charter.rewards.service.RewardsCalculatorService;
import com.charter.rewards.types.CustomerRewardsSummary;
import com.charter.rewards.types.CustomerTransactionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController("/rewards")
public class RewardsCalculatorController extends BaseRestController {

    private final RewardsCalculatorService rewardsCalculatorService;

    /**
     *
     * @param id
     * @param period
     * @return
     */
    @PostMapping("/{id}")
    public ResponseEntity<?> getCustomerRewardsById(final @PathVariable("id") Long id,
                                                    final @RequestParam(name = "months-prev", defaultValue = "3") Integer period) {
        log.info("Received customer rewards request for customer[id]={}, for {}-months' history", id, period);
        final CustomerRewardsSummary customerTransaction = rewardsCalculatorService.getCustomerRewards(id, period);
        return ResponseEntity.ok(null);
    }

    /**
     * @param
     * @return
     */
    @PostMapping
    public ResponseEntity<?> getAllRewards(final @RequestParam(name = "months-prev", defaultValue = "3") Integer period) {
        log.info("Received ALL rewards request for {}-months' history", period);
        final List<CustomerRewardsSummary> customerTransactions = rewardsCalculatorService.getAllRewards(period);
        return ResponseEntity.ok(null);
    }

    /**
     *
     * @param id
     * @return
     */
    @PostMapping("/{id}")
    public ResponseEntity<?> getCustomerTransactions(final @PathVariable("id") Long id,
                                                     final @RequestParam(name = "months-prev", required = false) Integer period) {
        final List<CustomerTransactionDto> customerTransaction = rewardsCalculatorService.getAllTransactions(id, period);
        return ResponseEntity.ok(null);
    }
}
