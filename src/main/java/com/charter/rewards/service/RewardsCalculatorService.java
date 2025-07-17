package com.charter.rewards.service;

import com.charter.rewards.repository.CustomerRepository;
import com.charter.rewards.repository.CustomerTransactionRepository;
import com.charter.rewards.repository.model.CustomerAccount;
import com.charter.rewards.repository.model.CustomerTransaction;
import com.charter.rewards.types.AccountStatus;
import com.charter.rewards.types.CustomerRewardsSummary;
import com.charter.rewards.types.CustomerTransactionDto;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.annotation.Nullable;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.charter.rewards.types.AccountStatus.INACTIVE;

/**
 * todo: add
 */
@Service
@RequiredArgsConstructor
public class RewardsCalculatorService {

    private final CustomerRepository customerRepository;
    private final CustomerTransactionRepository customerTransactionRepository;

    /**
     * Retrieves all customers' rewards summaries within a range of consecutive months past, beginning at current.
     * @param customerId - The unique serial ID of the customer in request.
     * @param transactionPeriod - The number of full months to include; for example, f(2, March) => [01/01/curr-year, 03/current date]; if null, all.
     * @return
     */
    @Nullable
    public CustomerRewardsSummary getCustomerRewards(final @NonNull Long customerId,
                                                     final @Nullable Integer transactionPeriod) {
        List<CustomerTransaction> transactions = customerTransactionRepository.findAllBy(customerId);
        // #calculateRewards
        return null;
    }

    /**
     * Retrieves all customers' rewards summaries within a range of consecutive months past, beginning at current.
     * @param transactionPeriod - The number of full months to include; for example, f(2, March) => [01/01/curr-year, 03/current date]; if null, all.
     * @return
     */
    @Nullable
    public List<CustomerRewardsSummary> getAllRewards(@Nullable Integer transactionPeriod) {
        Map<Long, List<CustomerTransaction>> transactions = customerTransactionRepository.findAll()
                .stream().collect(Collectors.groupingBy(tx -> tx.getCustomer().getCustomerId()));
        // #calculateRewards
        return null;
    }

    /**
     * Retrieves all transactions belonging to a requested customer, optionally within a range of consecutive months past, beginning at current.
     * @param customerId - The unique serial ID of the customer in request.
     * @param transactionPeriod - The number of full months to include; for example, f(2, March) => [01/01/curr-year, 03/current date]; if null, all.
     * @return If the customer account has not been canceled, the list of (optionally, time-bound) transactions.
     */
    @Nullable
    public List<CustomerTransactionDto> getAllTransactions(final @NonNull Long customerId, final Integer transactionPeriod) {
        final CustomerAccount customerAccount = customerRepository.findById(customerId)
                .filter(ca -> !ca.getAccountStatus().equals(INACTIVE))
                .orElseThrow(() -> new RuntimeException("No active customer found with ID!"));

        List<CustomerTransaction> transactions = customerTransactionRepository
                .findAllBy(customerAccount.getCustomerId());
        // map to dto
        return transactions.stream()
                .map(convertToDto).toList();
    }

    private Function<CustomerTransaction, CustomerTransactionDto> convertToDto = (CustomerTransaction tx) -> {
        return null;
    };

}
