<#import "../parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/hooksUser" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}"
                       placeholder="Search by name hook">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Manufacturer</th>
            <th scope="col">Size</th>
            <th scope="col">Price</th>
            <th scope="col">Action
            <th>
        </tr>
        </thead>
        <tbody>
        <#list hooks as hook>
            <tr>
                <th>${hook.name}</th>
                <th>${hook.manufacturer}</th>
                <th>${hook.size}</th>
                <th>${hook.price}</th>
                <td><a href="/hooksUser/${hook.id}">Add to order</a></td>
            </tr>
        <#else>
            No hook
        </#list>
        </tbody>
    </table>

</@c.page>

