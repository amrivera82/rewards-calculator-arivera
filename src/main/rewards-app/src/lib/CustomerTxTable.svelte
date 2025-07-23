<script lang="js">
    let {transactions} = $props();

</script>

<div>
    {#if transactions}
        <h3>Transactions</h3>
        <table class="borderless">
            <thead>
            <tr>
                <td>ID</td>
                <td>Amount</td>
                <td>Note</td>
                <td>Transaction Time</td>
                <td>Post Time</td>
            </tr>
            </thead>
            <tbody class="dm-mono-light">
            {#each transactions as transaction}
                <tr>
                    <td>{transaction.transactionId}</td>
                    <td>{transaction.amount}</td>
                    <td>{transaction.note}</td>
                    <td>{transaction.transactionDateTime}</td>
                    <td>{transaction.postDateTime}</td>
                </tr>
            {/each}
            </tbody>
        </table>
    {/if}
</div>

<style>
    table {
        border: solid #2c2c2c 1px;
        background: rgba(23, 108, 212, 0.93);
        margin-top: -10px;
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
        border-bottom: solid #2c2c2c 10px;
    }

    .borderless thead {
        background: rgba(255, 255, 255, 0.93);
    }

    .dm-mono-light td {
        font-size: .8em;
    }
</style>