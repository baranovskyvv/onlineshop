<#assign
know= Session.SPRING_SECURITY_CONTEXT??
>

<#if know>
    <#assign
    user= Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name= user.getUsername()
  customer_id=user.getId()
    isAdmin = user.isAdmin()>
<#else>
    <#assign
    name = "unknown"
    isAdmin = false>
</#if>