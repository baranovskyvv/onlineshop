<#import "../parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/lines" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}"
                       placeholder="Search by name line">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Add new lines
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
                <input type="text" class="form-control" name="diameter" placeholder="Diameter">
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
            <th>Diameter</th>
            <th>Price</th>
            <th>Currently Amount</th>
            <th colspan="2">Action
            <th>
        </tr>
        </thead>
        <tbody>
        <#list lines as line>
            <tr>
                <th>${line.id}</th>
                <th>${line.name}</th>
<#--                <th><#if line.filename??>-->
<#--                        <img src="/img/${line.filename}" class="card-img-top">-->
<#--                    </#if></th>-->
                <th>${line.manufacturer}</th>
                <th>${line.length}</th>
                <th>${line.diameter}</th>
                <th>${line.price}</th>
                <th>${line.currentlyamount}</th>
                <td><a href="/lines/${line.id}">Edit</a></td>
                <td><a href="/lines/delete/${line.id}">Delete</a></td>
            </tr>

        <#else>
            No line
        </#list>

        </tbody>
    </table></div>

</@c.page>

