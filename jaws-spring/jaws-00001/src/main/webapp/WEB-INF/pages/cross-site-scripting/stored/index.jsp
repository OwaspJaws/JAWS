<%--
  @author Sam Theys
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/includes/header.jsp" %>

<div class="col-xs-12 col-sm-9">
    <p class="pull-right visible-xs">
        <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
    </p>
    <div style="clear:both; width: 0; height: 0">&nbsp;</div>
    <a href="<c:url value="${nav.XSS_STORED}${nav.GOOD}"/>">
        <div class="col-xs-6 alert alert-success text-center <c:if test="${nav.GOOD eq tab}">tab-active</c:if>">Good
        </div>
    </a>
    <a href="<c:url value="${nav.XSS_STORED}${nav.BAD}"/>">
        <div class="col-xs-6 alert alert-danger text-center <c:if test="${nav.BAD eq tab}">tab-active</c:if>">Bad</div>
    </a>

    <div class="tab-content">
        <div class="tab-pane <c:if test="${nav.GOOD eq tab}">active</c:if>" id="good">
            <div>
                <c:if test="${nav.GOOD eq tab}">
                    <%@include file="stored-xss.jsp" %>
                </c:if>
            </div>
        </div>
        <div class="tab-pane <c:if test="${nav.BAD eq tab}">active</c:if>" id="bad">
            <div>
                <c:if test="${nav.BAD eq tab}">
                    <%@include file="stored-xss.jsp" %>
                </c:if>
            </div>
        </div>
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Documentation</h3>
            </div>
            <div class="panel-body">
            </div>
        </div>
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">External sources</h3>
            </div>
            <div class="panel-body">
            </div>
        </div>
    </div>

<%@include file="/WEB-INF/includes/footer.jsp" %>