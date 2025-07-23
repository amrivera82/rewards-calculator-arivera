<script>
    let { customers, getRewardsForCustomer } = $props();
</script>

<div>
    <table>
        <thead>
        <tr>
            <td><h4>Customers</h4></td>
            <td><a href="#" onclick={() => displayAllRew()}>View All Rewards</a></td>
        </tr>
        </thead>

        <tbody class="dm-mono-light">
        {#each customers as customer}
            <tr>
                <td><a onclick={() => getRewardsForCustomer(customer.customerId)} href="#">{customer.firstName}</a></td>
                <td>{customer.lastName}</td>
                <td>{customer.createdDate}</td>
                <td>{customer.accountStatus}</td>
                <td>{customer.timeZoneId}</td>
            </tr>
        {/each}
        </tbody>
    </table>
</div>

<style>
    table {
        border: solid #2c2c2c 1px;
        background: rgba(23, 108, 212, 0.93);
    }
    td {
        border: dotted #2c2c2c 1px;
        background: #ffffff;
        padding: 5px 20px;
    }
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
    .customer-info > div:first-child {
        padding-left: 30px;
    }
    .dm-mono-light td {
        font-size: 12px;
    }
</style>