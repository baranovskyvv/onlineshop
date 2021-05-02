<#import "../parts/common.ftl" as c>
<#include "../parts/security.ftl">
<@c.page>
    Add rod to order
    <form action="/rodsUser" method="post">
        Name:${rod.name}    <br>
        <input type="hidden" value="${rod.id}" name="id">
        <input type="hidden" value="${customer_id}" name="customer_id">
        Manufacturer: ${rod.manufacturer} <br>
        Length: ${rod.length?string("0.##")} <br>
        Test max:${rod.testMax?string("0.##")} <br>
        Test min:${rod.testMin?string("0.##")} <br>
        Price:${rod.price?string("0.##")} <br>
        <input type="text" class="form-control" name="amount" placeholder="Amount"/>
        <input type="hidden" value="${rod.price?string("0.##")}" name="price"/>

        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit"> Add to order</button>
    </form>

</@c.page>