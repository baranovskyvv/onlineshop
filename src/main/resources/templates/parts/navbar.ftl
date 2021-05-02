<#include "security.ftl">
<#import "login.ftl" as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Fishing Store</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home </a>
            </li>

            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">User list </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Orders/a">Active orders</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Orders/d">Deactive orders</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/hooks">Hooks </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/lines">Lines </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/rods">Rods </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/reels">Reels</a>
                </li>

            <#else>
                <li class="nav-item">
                    <a class="nav-link" href="/hooksUser">Hooks </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/linesUser">Lines </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/rodsUser">Rods </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/reelsUser">Reels </a>
                </li>
            </#if>


        </ul>
        <#if isAdmin>
            <div class="navbar-text mr-3">${name}</div>
            <@l.logout/>
        <#else>


            <div class="navbar-text mr-3">${name}</div>
            <form action="/Cart">
                         <button class="btn btn-primary mr-5" type="submit">Cart</button>
            </form>
            <@l.logout/>
        </#if>

    </div>
</nav>