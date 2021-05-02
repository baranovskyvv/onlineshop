<#import  "parts/common.ftl" as c>

<@c.page>
    Order number ${id_ord}
    <div>
        <table class="table">

            <thead>

            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Price</th>
                <th>Amount</th>
                <th>Sum</th>

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
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
    <br/>
    <h2>Total price: ${totalPrice}</h2>
    <br/>
    <br/>
    <div>
        Name customer: ${user.username}<br/>
        City: ${address.city}<br/>
        Street: ${address.street}<br/>
        House: ${address.house}<br/>
        Flat: ${address.flat}<br/>
        Phone: ${address.phone}<br/>
    </div>

    <form action="/Orders/deactivate/${id_ord}">
        <button class="btn btn-primary" type="submit">Deactivate</button>
    </form>
</@c.page>