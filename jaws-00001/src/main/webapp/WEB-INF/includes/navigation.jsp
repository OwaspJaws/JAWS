<%--
  @author Sam Theys
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
    <div class="well sidebar-nav">
        <ul class="nav">
            <li>Injection</li>
            <li <c:if test="${navigation == 'sql-injection'}">class="active"</c:if>><a href="/sql-injection">SQL injection</a></li>
        </ul>
    </div>
    <!--/.well -->
</div>