<#import "../parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/rodsUser" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}"
                       placeholder="Search by name line">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>

    <table class="table">

        <thead>

        <tr>
            <th scope="col">Name</th>
            <th scope="col">Manufacturer</th>
            <th scope="col">Length</th>
            <th scope="col">Test max</th>
            <th scope="col">Test min</th>
            <th scope="col">Price</th>
             <th scope="col">Action<th>
        </tr>
        </thead>
        <tbody>
        <#list rods as rod>
            <tr>
                <th>${rod.name}</th>
                <th>${rod.manufacturer}</th>
                <th>${rod.length}</th>
                <th>${rod.testMax}</th>
                <th>${rod.testMin}</th>
                <th>${rod.price}</th>
                 <td><a href="/rodsUser/${rod.id}">Add to order</a></td>
            </tr>

        <#else>
            No rod
        </#list>

        </tbody>
    </table>

</@c.page>

