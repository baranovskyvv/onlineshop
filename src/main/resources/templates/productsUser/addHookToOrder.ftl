<#import "../parts/common.ftl" as c>
<#include "../parts/security.ftl">
<@c.page>
    Add hook to order
    <form action="/hooksUser" method="post">
        Name:${hook.name} <br>
        <input type="hidden" value="${hook.id}" name="id">
        <input type="hidden" value="${customer_id}" name="customer_id">

        Manufacturer: ${hook.manufacturer} <br/>
        Size :${hook.size?string("0.##")} <br/>
        Price:${hook.price?string("0.##")}<br/>
        <input type="hidden" value="${hook.price?string("0.##")}" name="price"/>
        <input type="text" class="form-control" name="amount" placeholder="Amount"/>


        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit"> Add to order</button>
    </form>

</@c.page>