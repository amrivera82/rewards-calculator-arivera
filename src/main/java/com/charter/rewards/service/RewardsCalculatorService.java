package com.charter.rewards.service;

import com.charter.rewards.controller.error.NotFoundException;
import com.charter.rewards.repository.CustomerRepository;
import com.charter.rewards.repository.CustomerTransactionRepository;
import com.charter.rewards.repository.model.CustomerAccount;
import com.charter.rewards.repository.model.CustomerTransaction;
import com.charter.rewards.types.CustomerAccountDto;
import com.charter.rewards.types.CustomerRewardsDto;
import com.charter.rewards.types.CustomerRewardsSummary;
import com.charter.rewards.types.CustomerTransactionDto;
import com.charter.rewards.util.RewardsUtil;
import jakarta.annotation.Nullable;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.charter.rewards.types.AccountStatus.INACTIVE;

/**
 * todo: add
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RewardsCalculatorService {

    private final CustomerRepository customerRepository;
    private final CustomerTransactionRepository customerTransactionRepository;

    /**
     * Retrieves all users.
     */
    public List<CustomerAccountDto> getAllCustomerAccounts() {
        return customerRepository.findAll()
                .stream().map(ca -> (CustomerAccountDto) RewardsUtil.convertToDto(ca, new CustomerAccountDto()))
                .toList();
    }

    /**
     * Retrieves all customers' rewards summaries within a range of consecutive months past, beginning at current.
     *
     * @param customerId        - The unique serial ID of the customer in request.
     * @param transactionPeriod - The number of full months to include; for example, f(2, March) => [01/01/curr-year, 03/current date]; if null, all.
     * @return
     */
    @Nullable
    public CustomerRewardsSummary getCustomerRewards(final @NonNull Long customerId, final @NonNull Integer transactionPeriod) {
        final ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.systemDefault());

        final List<CustomerTransaction> transactions = customerTransactionRepository.findAllByCustomerId(customerId);
        if (transactions.isEmpty()) {
            log.warn("No transactions found for customer[id]={}", customerId);
            throw new NotFoundException("No transactions found for customer!");
        }

        final CustomerAccount account = transactions.getFirst().getCustomer();
        List<CustomerRewardsDto> rewards = RewardsUtil.calculateRewards(transactions.stream()
                .filter(tx -> tx.getTransactionDateTime()
                        .isAfter(ZonedDateTime
                                .of(LocalDate.now().atTime(0, 0), ZoneId.of(account.getTimeZoneId()))
                                    .minusMonths(transactionPeriod))).toList());

        final CustomerAccountDto accountDto = new CustomerAccountDto(account.getCustomerId(), account.getFirstName(), account.getFirstName(),
                account.getLastName(), account.getCreatedDate(), account.getAccountStatus());

        return CustomerRewardsSummary.builder()
                .customerId(customerId)
                .customerRewardDtos(rewards)
                .totalRewardsAmount(rewards.stream()
                        .map(CustomerRewardsDto::getPoints)
                        .reduce(Integer::sum)
                        .orElse(0))
                .build();
    }

    /**
     * Retrieves all customers' rewards summaries within a range of consecutive months past, beginning at current.
     *
     * @param transactionPeriod - The number of full months to include; for example, f(2, March) => [01/01/curr-year, 03/current date]; if null, all.
     * @return
     */
    @Nullable
    public List<CustomerRewardsSummary> getAllRewards(@Nullable Integer transactionPeriod) {
        Map<Long, List<CustomerTransaction>> transactions = customerTransactionRepository
                .findAll().stream().collect(Collectors.groupingBy(tx -> tx.getCustomer().getCustomerId()));
        // #calculateRewards
        return null;
    }

    /**
     * Retrieves all transactions belonging to a requested customer, optionally within a range of consecutive months past, beginning at current.
     *
     * @param customerId        - The unique serial ID of the customer in request.
     * @param transactionPeriod - The number of full months to include; for example, f(2, March) => [01/01/curr-year, 03/current date]; if null, all.
     * @return If the customer account has not been canceled, the list of (optionally, time-bound) transactions.
     */
    @Nullable
    public List<CustomerTransactionDto> getAllTransactions(final @NonNull Long customerId, final Integer transactionPeriod) {
        final CustomerAccount customerAccount = customerRepository.findById(customerId)
                .filter(ca -> !ca.getAccountStatus().equals(INACTIVE)).orElseThrow(() -> new NotFoundException("No active customer found with ID!"));

        List<CustomerTransaction> transactions = customerTransactionRepository.findAllByCustomerId(customerAccount.getCustomerId());

        return transactions.stream().map(tx -> (CustomerTransactionDto) RewardsUtil.convertToDto(tx, new CustomerTransactionDto())).toList();
    }

}
