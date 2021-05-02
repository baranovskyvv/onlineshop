<#import "../parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/linesUser" class="form-inline">
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
            <th scope="col">Diameter</th>
            <th scope="col">Price</th>
             <th scope="col">Action<th>
        </tr>
        </thead>
        <tbody>
        <#list lines as line>
            <tr>
                <th>${line.name}</th>
                <th>${line.manufacturer}</th>
                <th>${line.length}</th>
                <th>${line.diameter}</th>
                <th>${line.price}</th>
                 <td><a href="/linesUser/${line.id}">Add to order</a></td>
            </tr>

        <#else>
            No line
        </#list>

        </tbody>
    </table>

</@c.page>

