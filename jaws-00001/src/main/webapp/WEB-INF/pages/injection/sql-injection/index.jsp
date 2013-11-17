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
    <a href="#good" data-toggle="tab">
        <div class="col-xs-6 alert alert-success text-center tab-active">Good</div>
    </a>
    <a href="#bad" data-toggle="tab">
        <div class="col-xs-6 alert alert-danger text-center">Bad</div>
    </a>
    <div class="tab-content">
        <!-- TODO: make clear distinction when good/bad sample is chosen by a user -->
        <div class="tab-pane active" id="good">
            <div>
                <form action="<c:url value="${nav.INJECTION_SQL}${nav.GOOD}"/>" method="post" role="form">
                    <div class="form-group">
                        <label for="inputBreed">Search the fish database by breed</label>
                        <input type="text" class="form-control" id="inputBreed" name="breed" placeholder="Enter a breed">
                    </div>
                    <button type="submit" name="search" value="search" class="btn btn-default">Search</button>
                    <%@include file="results.jsp" %>
                </form>
            </div>
        </div>
        <div class="tab-pane" id="bad">
            <div>
                <form action="<c:url value="${nav.INJECTION_SQL}${nav.BAD}"/>" method="post" role="form">
                    <div class="form-group">
                        <label for="inputBreed">Search the fish database by breed</label>
                        <input type="text" class="form-control" id="inputBreed" name="breed" placeholder="Enter a breed">
                    </div>
                    <button type="submit" name="search" value="search" class="btn btn-default">Search</button>
                    <%@include file="results.jsp" %>
                </form>
        </div>
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Documentation</h3>
        </div>
        <div class="panel-body">
            The following breeds are in the database: Spiny dogfish, Blacktailed spurdog and Horn shark
        </div>
    </div>
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">External sources</h3>
        </div>
        <div class="panel-body">
            https://www.owasp.org/index.php/SQL_Injection‎
        </div>
    </div>
</div>

<%@include file="/WEB-INF/includes/footer.jsp" %>