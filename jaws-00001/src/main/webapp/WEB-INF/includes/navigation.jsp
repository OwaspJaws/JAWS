<%--
  @author Sam Theys
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
    <div class="well sidebar-nav">
        <ul class="nav">

            <li>Injection</li>
            <li <c:if test="${navigation eq nav.INJECTION_SQL}">class="active"</c:if>>
                <a href=<c:url value="${nav.INJECTION_SQL}"/>>SQL injection</a>
            </li>
            <li <c:if test="${navigation eq nav.INJECTION_LDAP}">class="active"</c:if>>
                <a href=<c:url value="${nav.INJECTION_LDAP}"/>>LDAP injection</a>
            </li>

            <li>Cross site scripting</li>
            <li <c:if test="${navigation eq nav.XSS_STORED}">class="active"</c:if>>
                <a href="<c:url value="${nav.XSS_STORED}"/>">Stored XSS</a>
            </li>
            <li <c:if test="${navigation eq nav.XSS_DOM}">class="active"</c:if>>
                <a href="<c:url value="${nav.XSS_DOM}"/>">Dom XSS</a>
            </li>

        </ul>
    </div>
    <!--/.well -->
</div>