<#import "../parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/hooks" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}"
                       placeholder="Search by name rod">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Add new rod
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
                <input type="text" class="form-control" name="length" placeholder="Length">
            </div>

            <div class="form-group">
                <input type="text" class="form-control" name="testMax" placeholder="Test Max">
            </div>

            <div class="form-group">
                <input type="text" class="form-control" name="testMin" placeholder="Test Min">
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
                <th>Length</th>
                <th>Test max</th>
                <th>Test min</th>
                <th>Price</th>
                <th>Currently Amount</th>
                <th colspan="2">Action
                <th>
            </tr>
            </thead>
            <tbody>
            <#list rods as rod>
                <tr>
                    <th>${rod.id}</th>
                    <th>${rod.name}</th>
                    <#--                <th><#if line.filename??>-->
                    <#--                        <img src="/img/${line.filename}" class="card-img-top">-->
                    <#--                    </#if></th>-->
                    <th>${rod.manufacturer}</th>
                    <th>${rod.length}</th>
                    <th>${rod.testMax}</th>
                    <th>${rod.testMin}</th>
                    <th>${rod.price}</th>
                    <th>${rod.currentlyamount}</th>
                    <td><a href="/rods/${rod.id}">Edit</a></td>
                    <td><a href="/rods/delete/${rod.id}">Delete</a></td>
                </tr>

            <#else>
                No rods
            </#list>

            </tbody>
        </table>
    </div>

</@c.page>

