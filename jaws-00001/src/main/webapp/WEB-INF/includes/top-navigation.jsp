<%--
  @author Sam Theys
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="collapse navbar-collapse">
    <ul class="nav navbar-nav">
        <li <c:if test="${navigation == 'index'}">class="active"</c:if> ><a href="/">Home</a></li>
        <li <c:if test="${navigation == 'about'}">class="active"</c:if> ><a href="/about">About</a></li>
        <li <c:if test="${navigation == 'contact'}">class="active"</c:if> ><a href="/contact">Contact</a></li>
    </ul>
</div>