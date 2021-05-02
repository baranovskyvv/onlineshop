<#import "../parts/common.ftl" as c>
<#include "../parts/security.ftl">
<@c.page>
    Add hook to order
    <form action="/hooksUser" method="post">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input type="hidden" value="${hook.id}">
        Type : "${hook.type}" <br/>
        Name Product : "${hook.name_product}" <br/>
        Price: "${hook.price}" <br/>
        Amount: <input type="text" name="amount"
                       value="<c:out value="${hookCart.amount}" />"/> <br/>

        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit"> Add to order</button>
    </form>

</@c.page>
