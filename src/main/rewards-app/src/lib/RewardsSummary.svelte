<script>
    let { summary, loadAllTransactionsForCustomer } = $props();
</script>

<div>
<h3>Points Summary</h3>
{#if !summary.value}
    <p>Click on a name above</p>
{:else}
    <table class="borderless">
        <thead>
        <tr>
            <td>Points</td>
            <td>Period Start</td>
            <td>Period End</td>
            <td>History</td>
        </tr>
        </thead>
        <tbody class="dm-mono-light">
        {#each summary.value.customerRewards as customerReward}
            <tr>
                <td>{customerReward.points}</td>
                <td>{customerReward.beginDateTime}</td>
                <td>{customerReward.endDateTime}</td>
                <td><a href="#" onclick={() => loadAllTransactionsForCustomer(summary.value.customerId, 3)}>All
                    Transactions</a>
                </td>
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
    }

    .borderless thead {
        background: rgba(241, 195, 102, 0.93);
    }

    a {
        text-decoration: none;
        color: rgba(10, 93, 197, 0.93);
        font-style: oblique;
    }

    .dm-mono-light td {
        font-size: .8em;
    }
</style>