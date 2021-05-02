<#import "../parts/common.ftl" as c>
<@c.page>
    Line editor

    <form action="/lines/update" method="post">
        Name: <input type="text" name="name" value = "${line.name}">
        <input type="hidden" value="${line.id}" name="id">
        <br>
        Manufacturer: <input type="text" value="${line.manufacturer}" name="manufacturer">  <br>
        Length:<input type="text" value="${line.length?string("0.##")}" name="length">  <br>
       Diameter: <input type="text" value="${line.diameter?string("0.##")}" name="diameter">  <br>
        Price:<input type="text" value="${line.price?string("0.##")}" name="price">  <br>
        Currently amount:<input type="text" value="${line.currentlyamount?string("0")}" name="currentlyamount">  <br>
               <input type="hidden" value ="${_csrf.token}" name="_csrf">
        <button type="submit"> Save</button>
    </form>
</@c.page>