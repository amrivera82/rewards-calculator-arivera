package com.charter.rewards.util;

import com.charter.rewards.repository.model.CustomerTransaction;
import com.charter.rewards.types.CustomerRewardsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/*
 * "A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every
 * dollar spent between $50 and $100 in each transaction."
 */
public class RewardsUtil {

    @NonNull
    public static List<CustomerRewardsDto> calculateRewards(List<CustomerTransaction> customerTransactions) {
        return customerTransactions.stream()
                .collect(Collectors.groupingBy(tx -> tx.getTransactionDateTime()
                        .format(DateTimeFormatter.ofPattern("MMyyyy")), toList()))
                .values().stream()
                .map(monthOfTransactions ->
                        new CustomerRewardsDto(customerTransactions.getFirst().getCustomer().getCustomerId(),
                                monthOfTransactions.getFirst().getTransactionDateTime(),
                                monthOfTransactions.getLast().getTransactionDateTime(),
                                monthOfTransactions.stream().map(tx ->
                                                calculateRewardsInternal(tx.getAmount().intValue(), 0))
                                        .reduce(Integer::sum)
                                        .orElse(0))).toList();
    }

    public static int calculateRewardsInternal(int amount, int points) {
        if (amount > 50 && amount <= 100) {
            return amount + points;
        } else if (amount > 100) {
            if (points == 0) {
                points += 50; // The first 50 dollars are worth 1 dollar each
            }
            int v1 = (amount / 100) * 100;
            int v2 = v1 - 100;
            int v3 = amount - v1;
            points += (v2 * 2) + (v3 * 2);
            return points;
        } else {
            return 0;
        }
    }

    public static Object convertToDto(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
