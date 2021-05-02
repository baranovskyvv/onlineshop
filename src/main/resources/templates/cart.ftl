<#import  "parts/common.ftl" as c>

<@c.page>
<#--    Order number ${id_ord}-->
    <div>

        <table class="table">

            <thead>
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Price</th>
                <th>Amount</th>
                <th>Sum</th>
                <th colspan="2">Actions</th>
            </tr>
            </thead>
            <tbody>
            <#list hooks as hook>
                <tr>
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <input type="hidden" value="${hook.id}">
                    <th>${hook.name_product}</th>
                    <th>${hook.type}</th>
                    <th>${hook.price}</th>
                    <th>${hook.amount}</th>
                    <th>${hook.price*hook.amount}</th>
                    <td><a href="/Cart/changeValueForm/${hook.id}&${hook.type}">Change amount</a></td>
                    <td><a href="/Cart/delete/${hook.id}&${hook.type}">Delete</a></td>
                </tr>
            </#list>
            <#list reels as reel>
                <tr>
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <input type="hidden" value="${reel.id}">
                    <th>${reel.name_product}</th>
                    <th>${reel.type}</th>
                    <th>${reel.price}</th>
                    <th>${reel.amount}</th>
                    <th>${reel.price*reel.amount}</th>
                    <td><a href="/Cart/${reel.id}">Change amount</a></td>
                    <td><a href="/Cart/delete/${reel.id}&${reel.type}">Delete</a></td>
                </tr>
            </#list>
            <#list rods as rod>
                <tr>
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <input type="hidden" value="${rod.id}">
                    <th>${rod.name_product}</th>
                    <th>${rod.type}</th>
                    <th>${rod.price}</th>
                    <th>${rod.amount}</th>
                    <th>${rod.price*rod.amount}</th>
                    <td><a href="/Cart/${rod.id}">Change amount</a></td>
                    <td><a href="/Cart/delete/${rod.id}&${rod.type}">Delete</a></td>
                </tr>
            </#list>
            <#list lines as line>
                <tr>
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <input type="hidden" value="${line.id}">
                    <th>${line.name_product}</th>
                    <th>${line.type}</th>
                    <th>${line.price}</th>
                    <th>${line.amount}</th>
                    <th>${line.price*line.amount}</th>
                    <td><a href="/Cart/${line.id}">Change amount</a></td>
                    <td><a href="/Cart/delete/${line.id}&${line.type}">Delete</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
   <h2>Total price: ${totalPrice}</h2>


            <form action="/Cart/address" method="post">
                <input type="hidden"  name="id" value="">
                <input type="hidden" value="${_csrf.token}" name="_csrf">
                City: <input type="text" name="city" placeholder="Write your city"><br/>
                Street: <input type="text" name="street"  placeholder="Write your street"><br/>
                House: <input type="text" name="house"  placeholder="Write your house"><br/>
                Flat: <input type="text" name="flat"  placeholder="Write your flat"><br/>
                Phone: <input type="tel" name="phone" list="tel-list" placeholder="+375 (12) 345-67-89" pattern="\+375\s?[\(]{0,1}[0-9]{2}[\)]{0,1}\s?\d{3}[-]{0,1}\d{2}[-]{0,1}\d{2}"><br/>

                <button type="submit"> Save</button>
            </form>
</@c.page>

