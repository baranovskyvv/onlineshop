<#import "../parts/common.ftl" as c>
<#include "../parts/security.ftl">
<@c.page>
    Add reel to order
    <form action="/reelsUser" method="post">
        Name:${reel.name}    <br>
        <input type="hidden" value="${reel.id}" name="id">
        <input type="hidden" value="${customer_id}" name="customer_id">

        Manufacturer: ${reel.manufacturer} <br>
        Amount of balls:${reel.amount_balls?string("0.##")} <br>
        Price:${reel.price?string("0.##")} <br>
        <input type="hidden" value="${reel.price?string("0.##")}" name="price"/>
        <input type="text" class="form-control" name="amount" placeholder="Amount"/>


        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit"> Add to order</button>
    </form>

</@c.page>