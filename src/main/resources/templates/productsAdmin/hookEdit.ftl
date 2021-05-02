<#import "../parts/common.ftl" as c>
<@c.page>
    Hook editor

    <form action="/hooks/update" method="post">
        Name: <input type="text" name="name" value="${hook.name}">
        <input type="hidden" value="${hook.id}" name="id">
        <br>
        Manufacturer: <input type="text" value="${hook.manufacturer}" name="manufacturer"> <br>
        Size:<input type="text" value="${hook.size?string("0.##")}" name="size"> <br>
        Price:<input type="text" value="${hook.price?string("0.##")}" name="price"> <br>
        Currently amount:<input type="text" value="${hook.currentlyamount?string("0")}" name="currentlyamount"> <br>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit"> Save</button>
    </form>
</@c.page>