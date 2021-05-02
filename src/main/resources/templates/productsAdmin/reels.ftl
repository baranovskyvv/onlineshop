<#import "../parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/reels" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}"
                       placeholder="Search by name reel">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Add new reels
    </a>


    <div class="collapse" id="collapseExample">

        <form method="post">

            <div class="form-group">
                <input type="text" class="form-control" name="name" placeholder="Name"/>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="manufacturer" placeholder="Manufacturer">
            </div>

            <div class="form-group">
                <input type="text" class="form-control" name="amount_balls" placeholder="Amount balls">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="price" placeholder="Price">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="currentlyamount" placeholder="CurrentlyAmount">
            </div>
            <#--            <div class="form-group">-->
            <#--                <div class="custom-file">-->
            <#--                    <input type="file" name="file" id="customFile">-->
            <#--                    <label class="custom-file-label" for="customFile">Choose file</label>-->
            <#--                </div>-->
            <#--            </div>-->
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
    <div>
        <table class="table">

            <thead>

            <tr>
                <th>Id</th>
                <th>Name</th>
                <#--            <th>Picture</th>-->
                <th>Manufacturer</th>
                <th>Amount of balls</th>
                <th>Price</th>
                <th>Currently Amount</th>
                <th colspan="2">Action
                <th>
            </tr>
            </thead>
            <tbody>
            <#list reels as reel>
                <tr>
                    <th>${reel.id}</th>
                    <th>${reel.name}</th>
                    <#--                <th><#if line.filename??>-->
                    <#--                        <img src="/img/${line.filename}" class="card-img-top">-->
                    <#--                    </#if></th>-->
                    <th>${reel.manufacturer}</th>
                    <th>${reel.amount_balls}</th>
                    <th>${reel.price}</th>
                    <th>${reel.currentlyamount}</th>
                    <td><a href="/reels/${reel.id}">Edit</a></td>
                    <td><a href="/reels/delete/${reel.id}">Delete</a></td>
                </tr>

            <#else>
                No reel
            </#list>

            </tbody>
        </table>
    </div>

</@c.page>

