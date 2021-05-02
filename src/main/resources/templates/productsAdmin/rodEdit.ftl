<#import "../parts/common.ftl" as c>
<@c.page>
    Rod editor

    <form action="/rods/update" method="post">
        Name: <input type="text" name="name" value="${rod.name}">
        <input type="hidden" value="${rod.id}" name="id">
        <br>
        Manufacturer: <input type="text" value="${rod.manufacturer}" name="manufacturer"> <br>
        Length:<input type="text" value="${rod.length?string("0.##")}" name="length"> <br>
        Test Max:<input type="text" value="${rod.testMax?string("0.##")}" name="testMax"> <br>
        Test Min:<input type="text" value="${rod.testMin?string("0.##")}" name="testMin"> <br>
        Price:<input type="text" value="${rod.price?string("0.##")}" name="price"> <br>
        Currently amount:<input type="text" value="${rod.currentlyamount?string("0")}" name="currentlyamount"> <br>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit"> Save</button>
    </form>
</@c.page>