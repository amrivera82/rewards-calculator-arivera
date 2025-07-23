package com.charter.rewards;

import com.charter.rewards.controller.RewardsCalculatorController;
import com.charter.rewards.repository.CustomerRepository;
import com.charter.rewards.repository.CustomerTransactionRepository;
import com.charter.rewards.service.RewardsCalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RewardsCalculatorControllerTests {

    @Mock
    RewardsCalculatorService rewardsCalculatorService;

    @InjectMocks
    RewardsCalculatorController rewardsCalculatorController;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    /*** Service's API method tests */
    // getAllCustomerAccountInfo
    @Test
    void test_getAllCustomerAccounts() {

    }

    // getCustomerRewards
    @Test
    void test_getCustomerRewards() {

    }

    // getAllRewards
    @Test
    void test_getAllRewards() {

    }

    // getAllTransactions
    @Test
    void test_getAllTransactions() {

    }

    /*** tests of calculation logic */

    @Test
    void test_calculateRewardsForPurchase() {

    }

}
