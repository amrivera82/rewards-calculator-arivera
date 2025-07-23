<script lang="js">
    import {fetchAllTransactionsForCustomerById, fetchRewardsForCustomerById} from "$lib/rewardsFunctions.js";
    import CustomerTxTable from "$lib/CustomerTxTable.svelte";
    import Customers from "$lib/Customers.svelte";
    import RewardsSummary from "$lib/RewardsSummary.svelte";

    let {customers} = $props();
    let summary = $state({value: null});
    let transactions = $state({value: null});

    export function getRewardsForCustomer(id) {
        transactions.value = null;
        fetchRewardsForCustomerById(id)
            .then(async (pr) => summary.value = await pr.json());
    }

    function displayAllRew() {
        alert(JSON.stringify(customers));
    }

    export function loadAllTransactionsForCustomer(id, monthsPrev) {
        fetchAllTransactionsForCustomerById(id, monthsPrev)
            .then(async (tr) => transactions.value = await tr.json());
    }
</script>

<div class="customer-info">
    <Customers {customers} {getRewardsForCustomer} />
    <div class="details">
        <RewardsSummary {summary} {loadAllTransactionsForCustomer}/>
        <CustomerTxTable transactions={transactions.value}/>
    </div>
</div>

<style>
    div.details {
        display: flow;
        padding: 0 45px;
    }

    table {
        border: solid #2c2c2c 1px;
        background: rgba(23, 108, 212, 0.93);
    }

    td {
        border: dotted #2c2c2c 1px;
        background: #ffffff;
        padding: 5px 20px;
    }

    .borderless,
    .borderless td {
        background: none;
        border: none !important;
    }

    .borderless thead {
        background: rgba(241, 195, 102, 0.93);
    }

    a {
        text-decoration: none;
        color: rgba(10, 93, 197, 0.93);
        font-style: oblique;
    }

    .customer-info {
        display: flex !important;
        padding-left: 4%;
    }

    .dm-mono-light td {
        font-size: 12px;
    }

</style>