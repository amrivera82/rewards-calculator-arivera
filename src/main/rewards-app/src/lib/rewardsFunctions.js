export const fetchRewardsForCustomerById = async(customerId) => {
    return await fetch(`http://localhost:8080/customer/${customerId}/rewards`, {
        method: 'POST',
        timeout: 30000
    });
};

export const fetchAllTransactionsForCustomerById = async(customerId, months) => {
    return await fetch(`http://localhost:8080/customer/${customerId}/transactions?months-prev=${months}`, {
        method: 'POST',
        timeout: 30000
    });
};

export const fetchAllCustomers = async() => {
    return await fetch(`http://localhost:8080/customer/all`, {
        timeout: 30000
    });
};