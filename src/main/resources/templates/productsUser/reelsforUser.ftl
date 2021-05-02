<#import "../parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/reelsUser" class="form-inline">
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
            <th scope="col">Amount of balls</th>
            <th scope="col">Price</th>
            <th scope="col">Action
            <th>
        </tr>
        </thead>
        <tbody>
        <#list reels as reel>
            <tr>
                <th>${reel.name}</th>
                <th>${reel.manufacturer}</th>
                <th>${reel.amount_balls}</th>
                <th>${reel.price}</th>
                <td><a href="/reelsUser/${reel.id}">Add to order</a></td>
            </tr>
        <#else>
            No reel
        </#list>
        </tbody>
    </table>

</@c.page>

