<#import "../parts/common.ftl" as c>
<@c.page>
    Reel editor

    <form action="/reels/update" method="post">
        Name: <input type="text" name="name" value="${reel.name}">
        <input type="hidden" value="${reel.id}" name="id">
        <br>
        Manufacturer: <input type="text" value="${reel.manufacturer}" name="manufacturer"> <br>
        Length:<input type="text" value="${reel.amount_balls?string("0.##")}" name="amount_balls"> <br>
        Price:<input type="text" value="${reel.price?string("0.##")}" name="price"> <br>
        Currently amount:<input type="text" value="${reel.currentlyamount?string("0")}" name="currentlyamount"> <br>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit"> Save</button>
    </form>
</@c.page>