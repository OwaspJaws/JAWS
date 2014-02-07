<%--
  @author Sam Theys
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="collapse navbar-collapse">
    <ul class="nav navbar-nav">
        <li
                <c:if test="${navigation == nav.GENERIC_INDEX}">class="active"</c:if> >
            <a href="<c:url value="${nav.GENERIC_INDEX}"/>">Home</a>
        </li>
        <li
                <c:if test="${navigation == nav.GENERIC_ABOUT}">class="active"</c:if> >
            <a href="<c:url value="${nav.GENERIC_ABOUT}"/>">About</a>
        </li>
        <li
                <c:if test="${navigation == nav.GENERIC_CONTACT}">class="active"</c:if> >
            <a href="<c:url value="${nav.GENERIC_CONTACT}"/>">Contact</a>
        </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-cog"></span><b
                    class="caret"></b></a>

            <ul class="dropdown-menu">
                <li><a href="/wip">Reset Database</a></li>
            </ul>
        </li>
    </ul>
</div>