<#import "../parts/common.ftl" as c>
<#include "../parts/security.ftl">
<@c.page>
    Add line to order
    <form action="/linesUser" method="post">
        Name:${line.name}    <br>
        <input type="hidden" value="${line.id}" name="id">
        <input type="hidden" value="${customer_id}" name="customer_id">

        Manufacturer: ${line.manufacturer} <br>
        Length: ${line.length?string("0.##")} <br>
        Diameter:${line.diameter?string("0.##")} <br>
        Price:${line.price?string("0.##")} <br>
        <input type="hidden" value="${line.price?string("0.##")}" name="price"/>
        <input type="text" class="form-control" name="amount" placeholder="Amount"/>


        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit"> Add to order</button>
    </form>

</@c.page>