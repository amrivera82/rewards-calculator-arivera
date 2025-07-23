<script module></script>

<script lang="js">
    import {fetchAllCustomers} from "$lib/rewardsFunctions.js";
    import CustomerInfo from "$lib/CustomerInfo.svelte";

    let customers;
    fetchAllCustomers()
        .then(async(cu) => customers = await cu.json())

</script>

<div class="container">
    <h1 class="title">Customer Rewards</h1>
    <CustomerInfo customers={customers} />
</div>

<style>
    .title {
        text-align: center;
    }
    .container {
        position: absolute;
        top: 75px;
        width: 100%;
    }
    .container,
    .container h1 {
        align-content: center;
        margin: auto;
        padding-bottom: 50px;
    }
</style>