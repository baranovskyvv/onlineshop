<#import  "parts/common.ftl" as c>

<@c.page>
    <div>
    <table class="table">

        <thead>

        <tr>
            <th>Id</th>
            <th>Active</th>
            <th>Customer name</th>
            <th colspan>Actions</th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <tr>
                <input type="hidden" value="${_csrf.token}" name="_csrf">
                <th> ${order.id_ord}</th>
                <th>${order.active?string('Active', 'Deactive')}</th>
                <th>${order.name}</th>
                <td><a href="/Orders/${order.id_ord}">Show order</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>